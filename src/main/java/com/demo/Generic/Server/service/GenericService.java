package com.demo.Generic.Server.service;

import com.demo.Generic.Server.model.Generic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Random;

@Service
public class GenericService {

    @Value("${MIN_SIZE}")
    private int MIN_SIZE;
    @Value("${MIN_SIZE}")
    private int MAX_SIZE;
    @Value("${MIN_SIZE}")
    private int MIN_SLEEP;
    @Value("${MIN_SIZE}")
    private int MAX_SLEEP;
    private static final Random RANDOM = new Random();
    private static final String ALPHANUMERIC = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public Generic generateGenericRecord() {

        Generic generic = new Generic(
                1,
                generateRandomString(),
                generateRandomString(),
                generateRandomString(),
                generateRandomString(),
                generateRandomString(),
                generateRandomString(),
                generateRandomString(),
                generateRandomString(),
                generateRandomString(),
                generateRandomString()
        );

        int totalSize = 0;
        for (Field field : Generic.class.getDeclaredFields()) {
            try {
                field.setAccessible(true);
                Object fieldValue = field.get(generic);
                if (fieldValue instanceof String) {
                    totalSize += ((String) fieldValue).getBytes().length;
                } else if (fieldValue instanceof Long) {
                    totalSize += Long.BYTES; // Size of Long in bytes
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        logger.info("Total size of the demo record: " + totalSize + " bytes");

        return generic;
    }

    public void sleep(){
        try {
            int sleepTime = RANDOM.nextInt(MAX_SLEEP - MIN_SLEEP + 1) + MIN_SLEEP;
            Thread.sleep(sleepTime);
            logger.info("Slept for " + sleepTime + " milliseconds.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String generateRandomString() {
        int size = MIN_SIZE + RANDOM.nextInt(MAX_SIZE - MIN_SIZE + 1);
        StringBuilder sb = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            sb.append(ALPHANUMERIC.charAt(RANDOM.nextInt(ALPHANUMERIC.length())));
        }
        return sb.toString();
    }

    public Generic postGeneric(Generic generic){
        return generic;
    }
}
