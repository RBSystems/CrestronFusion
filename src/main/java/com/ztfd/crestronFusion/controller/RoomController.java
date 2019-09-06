package com.ztfd.crestronFusion.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ztfd.crestronFusion.api.entities.APIRoom;
import com.ztfd.crestronFusion.servlet.RoomService;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@EnableAutoConfiguration

@RequestMapping("/room")
public class RoomController {

	private final RoomService roomService;
	@Autowired
	public RoomController(RoomService service){
		roomService=service;
	}
	
	@RequestMapping("/getRoomAll")
	@ResponseBody
	public List<APIRoom> getRoomAll() {
		return roomService.getRoomAll();
		/*for (APIRoom a : list) {
			System.out.println(a.getRoomName().getValue());
		}*/
	}
}
