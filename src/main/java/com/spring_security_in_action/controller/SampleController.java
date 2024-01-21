package com.spring_security_in_action.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class SampleController {
    Logger logger = Logger.getLogger(SampleController.class.getName());
    @GetMapping("/hello")
    public ResponseEntity<?> hello(){
//        Callable<String> task = () -> {
//            try{
//                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//                return authentication.getName();
//            }catch (NullPointerException ex){
//                logger.info("Failed to get Authentication name!");
//                return "Null";
//            }
//        };
//
//        ExecutorService service = Executors.newCachedThreadPool();
//        try{
//
//            service = new DelegatingSecurityContextExecutorService(service);
////            new DelegatingSecurityContextExecutor(service);
////            new DelegatingSecurityContextScheduledExecutorService();
//            String result = service.submit(task).get();
//            System.out.println(result);
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//
//        service.shutdown();

        return ResponseEntity.ok("Hello");
    }

    @GetMapping("/ohe")
    public ResponseEntity<?> ohe(){
        return ResponseEntity.ok("ওহে");
    }

    @GetMapping("/product/{code}")
    public ResponseEntity<?> product(@PathVariable String code){
        return ResponseEntity.ok(code);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(){
        return ResponseEntity.ok("Saved");
    }
}
