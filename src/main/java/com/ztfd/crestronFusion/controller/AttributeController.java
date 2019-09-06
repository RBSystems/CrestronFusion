package com.ztfd.crestronFusion.controller;


import com.ztfd.crestronFusion.api.entities.APIAttribute;
import com.ztfd.crestronFusion.servlet.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@EnableAutoConfiguration
@RequestMapping("attribute")
public class AttributeController {

    private final AttributeService attributeService;
    @Autowired
    public AttributeController(AttributeService attribute){
        attributeService=attribute;
    }

    @RequestMapping("getAttribute")
    @ResponseBody
    public List<APIAttribute> getAttributeByRoomID(@RequestParam String roomId){
        System.out.println(roomId);
        return attributeService.getAttributeByRoomID(roomId);
    }
}
