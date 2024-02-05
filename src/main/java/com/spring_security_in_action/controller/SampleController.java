package com.spring_security_in_action.controller;

import com.spring_security_in_action.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequiredArgsConstructor
public class SampleController {
    private final HelloService helloService;
    Logger logger = Logger.getLogger(SampleController.class.getName());
    @GetMapping("/hello")
    public ResponseEntity<?> hello(@RequestParam String name){
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

        return ResponseEntity.ok(helloService.greeting(name));
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
