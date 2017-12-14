package com.jim.async.controller;

import com.jim.async.model.service.IAsyncTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author: liu jun
 * @date: 18:34 2017/12/13
 * @ver: 1.0
 * @desc:
 */
@RestController
public class AsyncController {
	@Autowired
	private IAsyncTaskService service;

	@GetMapping("/")
	public Map<String, Long> getResult() throws ExecutionException, InterruptedException {
		Map<String, Long> map = new HashMap<>();

		for (int i = 10; i < 20; i++) {
			long start = System.currentTimeMillis();
			Future<Long> result = service.factorialCalculator(i);
			if (!result.isDone()) {
				Thread.sleep(1000);
			}
			long end = System.currentTimeMillis();
			map.put(String.valueOf(i) + ":" + (end - start) + "mill seconds", result.get());
		}

		return map;
	}
}
