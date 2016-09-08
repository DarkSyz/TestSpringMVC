package com.darksys.springmvc.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by ChenYZ on 9/7/2016.
 */

@Service
public class WelcomeService {
    private final Logger logger = Logger.getLogger(WelcomeService.class);

    public String getTitle(){
        return "Welcome";
    }

    public String getMessage(String name){
        return StringUtils.isEmpty(name)? "Hello World" : "Hello " + name;
    }
}
