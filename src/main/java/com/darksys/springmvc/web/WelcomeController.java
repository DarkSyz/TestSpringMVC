package com.darksys.springmvc.web;

import java.util.Map;

import com.darksys.springmvc.service.WelcomeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ChenYZ on 9/7/2016.
 */

@Controller
public class WelcomeController {

    private final Logger logger = Logger.getLogger(WelcomeController.class);
    private final WelcomeService welcomeService;

    @Autowired
    public WelcomeController(WelcomeService welcomeService){
        this.welcomeService = welcomeService;
    }

    @RequestMapping(value="/", method=RequestMethod.GET)
    public String index(Map<String, Object> model){
        logger.debug("index() is executed");
        model.put("title", welcomeService.getTitle());
        model.put("msg", welcomeService.getMessage(""));
        return "test/test";
    }

    @RequestMapping(value="/hello/{name:.+}", method=RequestMethod.GET)
    public ModelAndView hello(@PathVariable("name") String name){
        logger.debug("hello() is executed with name " + name);
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        model.addObject("title", welcomeService.getTitle());
        model.addObject("msg", welcomeService.getMessage(name));
        return model;
    }
}
