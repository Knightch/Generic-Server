package com.demo.Generic.Server.controller;

import com.demo.Generic.Server.model.Generic;
import com.demo.Generic.Server.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ratelimited")
public class GenericRateLimitedController {

    @Autowired
    GenericService genericService;

    @GetMapping
    public Generic getGenericRateLimited(){
        genericService.sleep();
        return genericService.generateGenericRecord();
    }

    @PostMapping("/post")
    public Generic postGenericRateLimited(@RequestBody Generic generic){
        genericService.sleep();
        return genericService.postGeneric(generic);
    }

    @PutMapping("/update")
    public Generic updateGenericRateLimited(@RequestBody Generic generic){
        genericService.sleep();
        return genericService.postGeneric(generic);
    }

    @DeleteMapping("/delete")
    public String deleteGenericRateLimited(String id){
        genericService.sleep();
        return "Deleted !";
    }
}
