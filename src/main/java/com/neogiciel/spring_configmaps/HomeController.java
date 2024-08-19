package com.neogiciel.spring_configmaps;

import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.neogiciel.spring_configmaps.util.Trace;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@CrossOrigin
@RestController()
public class HomeController {

    @Autowired
    private Environment env;

    @Autowired
    private ConfigApi config;


    /*
     * hello
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        Trace.info("HomeController [hello]");
        return "hello";
        
    }



    /*
     * Test
     */
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public HashMap<String, String> test() {
        Trace.info("HomeController [test]");
        HashMap<String, String> map = new HashMap<>();
        map.put("databaseUrl = ", env.getProperty("spring.datasource.url"));
        map.put("login = ", env.getProperty("spring.datasource.username"));
        map.put("password = ", env.getProperty("spring.datasource.password"));

        Trace.info("databaseUrl = " + env.getProperty("spring.datasource.url"));
        Trace.info("login = " + env.getProperty("spring.datasource.username"));
        Trace.info("password = " + env.getProperty("spring.datasource.password"));


        return map;
        
    }

    /*
     * Load
     */
    @RequestMapping(value = "/load", method = RequestMethod.GET)
    public HashMap<String, String> load() {
        Trace.info("HomeController [load]");

        config.load();
        HashMap<String, String> map = new HashMap<>();
        map.put("load = ", "load");
        return map;
        
    }

}
