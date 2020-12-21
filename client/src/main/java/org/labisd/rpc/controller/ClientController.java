package org.labisd.rpc.controller;

import java.util.ArrayList;
import java.util.List;

import org.labisd.rpc.dto.SumResult;
import org.labisd.rpc.feign.SumServerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Value("${app.sum.server}")
	String sumServer;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	SumServerClient serverClient;

	@GetMapping("/listsum") 
	public List<SumResult> getListSumResult (@RequestParam String[] values) {
		List<SumResult> list = new ArrayList<>();
		
		int acc = 0;
		for (int i = 0; i < values.length; i++) {
			int v = Integer.parseInt(values[i]);
			SumResult sumResult = getRemoteSumResult(acc, v);
			acc = sumResult.getSum();
			list.add(sumResult);
		}

		return list;
	}

	private SumResult getRemoteSumResult(int acc, int v) {
		String endpoint = String.format("%s/server/sum/%d/%d", sumServer, acc, v);
		return restTemplate.getForObject(endpoint, SumResult.class);
	}

	@GetMapping("/feign/listsum") 
	public List<SumResult> getListSumResultWithFeign (@RequestParam String[] values) {
		List<SumResult> list = new ArrayList<>();
		
		int acc = 0;
		for (int i = 0; i < values.length; i++) {
			int v = Integer.parseInt(values[i]);
			SumResult sumResult = serverClient.getSumResult(acc,v);
			acc = sumResult.getSum();
			list.add(sumResult);
		}

		return list;
	}
}
