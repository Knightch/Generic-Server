package com.demo.Generic.Server.service;

import com.demo.Generic.Server.model.Generic;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GenericServiceTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    GenericService genericService;

    @Test
    public void putGenericTest(){
        Generic generic = new Generic(0,"wvii31jMew","dUwqIHu4uA","mC7JEwvCW3","JZQtJwcaa3","ve2ON4Zs6f","LJDISmXyOI","BFcPCJoaOV","V3YlNRJxmZ","HWY4TH6zQP","aWowe7tjjt");
        Generic response = genericService.postGeneric(generic);
        logger.info(response.toString());
    }

    @Test
    public void getGenericTest(){
        genericService.sleep();
        Generic response = genericService.generateGenericRecord();
        logger.info(response.toString());
    }
}
