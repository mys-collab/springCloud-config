package com.newspringCloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controllerConfigClient {

    @Value("${config.info}")
    private String cofnigInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return cofnigInfo;
    }

}
