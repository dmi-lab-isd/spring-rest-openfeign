package org.labisd.rpc.controller;

import org.labisd.rpc.dto.SumResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/server")
public class ServerController {

	@Qualifier("serverId")
	@Autowired
	String serverId;

	@GetMapping("/sum/{a}/{b}") 
	public SumResult getSumResult (@PathVariable int a, @PathVariable int b) {
		
		SumResult result = new SumResult();
		result.setSum(a + b);
		result.setServerId(serverId);
		
		return result;
	}
}
