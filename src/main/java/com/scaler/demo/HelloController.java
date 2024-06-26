package com.scaler.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(){
        return "hey spring application";
    }

    @PostMapping("/add/{firstNumber}/{secondNumber}")
    public Integer doAddition(@PathVariable("firstNumber") int a, @PathVariable("secondNumber") int b){
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        return a + b;
    }

    @PostMapping("/user")
    public String addUser(){
        return "adding user to DB";
    }

    @PatchMapping("/users/{id}")
    public String updateUserDetails(@PathVariable("id") String userId){
        return "user " + userId + " updated";
    }

    @GetMapping("/query")
    public String runQuery(@RequestParam("text") String searchWord,
                           @RequestParam(value = "limit", defaultValue = "10") Integer queryLimit,
                           @RequestParam(value = "offset", required = false, defaultValue = "0") String queryOffset){
        return searchWord + " | " + queryLimit + " | " + queryOffset;
    }



}
