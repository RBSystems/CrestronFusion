package com.ztfd.crestronFusion.controller;


import com.ztfd.crestronFusion.servlet.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@EnableAutoConfiguration
@RequestMapping("/assets")
public class StatusController {

    private final StatusService statusService;
    @Autowired
    public StatusController(StatusService service){
        statusService=service;
    }
    @RequestMapping("/getStatus")
    @ResponseBody
    public HashMap<String,String> getAssetStatusByAssetID(@RequestParam String assetId){
        return statusService.getAssetStatusByAssetID(assetId);
    }

}
