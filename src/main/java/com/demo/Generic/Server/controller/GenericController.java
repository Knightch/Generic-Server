package com.demo.Generic.Server.controller;

import com.demo.Generic.Server.model.Generic;
import com.demo.Generic.Server.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class GenericController {

    @Autowired
    GenericService genericService;

    @GetMapping
    public Generic getGeneric(){
        genericService.sleep();
        return genericService.generateGenericRecord();
    }

    @PostMapping("/post")
    public Generic postGeneric(@RequestBody Generic generic){
        genericService.sleep();
        return genericService.postGeneric(generic);
    }

    @PutMapping("/update")
    public Generic updateGeneric(@RequestBody Generic generic){
        genericService.sleep();
        return genericService.postGeneric(generic);
    }

    @DeleteMapping("/delete")
    public String deleteGeneric(String id){
        genericService.sleep();
        return "Deleted !";
    }
}
