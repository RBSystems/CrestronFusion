package com.ztfd.crestronFusion.controller;


import com.ztfd.crestronFusion.api.entities.APIAsset;
import com.ztfd.crestronFusion.servlet.AssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@EnableAutoConfiguration

@RequestMapping("/assets")
public class AssetsController {

    private final AssetsService assetsService;
    @Autowired
    public AssetsController(AssetsService service){
        assetsService=service;
    }

    @RequestMapping("/getAssetsAll")
    @ResponseBody
    public List<APIAsset> getAssetsAll(){
        return assetsService.getAssetAll();
    }

    @RequestMapping("/getAssetByAssetID")
    @ResponseBody
    public List<APIAsset> getAssetByAssetID(@RequestParam String assetId){
        return assetsService.getAssetByAssetID(assetId);
    }

}
