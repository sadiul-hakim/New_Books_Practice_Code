package com.spring_security_in_action.controller;

import org.springframework.security.concurrent.DelegatingSecurityContextCallable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

@RestController
public class SampleController {
    Logger logger = Logger.getLogger(SampleController.class.getName());
    @GetMapping("/hello")
    public void hello(){
        Callable<String> task = () -> {
            try{
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                return authentication.getName();
            }catch (NullPointerException ex){
                logger.info("Failed to get Authentication name!");
                return "Null";
            }
        };

        ExecutorService service = Executors.newCachedThreadPool();
        try{

            var contextTask = new DelegatingSecurityContextCallable<>(task);
            String result = service.submit(contextTask).get();
            System.out.println(result);
        }catch (Exception ex){
            ex.printStackTrace();
        }

        service.shutdown();
    }
}
