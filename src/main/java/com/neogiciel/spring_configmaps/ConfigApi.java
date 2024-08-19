package com.neogiciel.spring_configmaps;

import org.springframework.stereotype.Component;

import com.neogiciel.spring_configmaps.util.Trace;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigApi {
    
    //@Value("${spring.datasource.url}")
    private String databaseUrl;
    //@Value("${spring.datasource.username}")
    private String login;
    //@Value("${spring.datasource.password}")
    private String password;

    /*
     * Constructeur
     */
    public ConfigApi(){

    }

    /*
     * load
     */
    public void load(){
        Trace.info("databaseUrl = " + databaseUrl);
        Trace.info("login = " + login);
        Trace.info("password = " + password);
        
    }

}
