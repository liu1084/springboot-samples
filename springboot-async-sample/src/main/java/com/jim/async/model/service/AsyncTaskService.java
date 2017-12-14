package com.jim.async.model.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @author: liu jun
 * @date: 16:14 2017/12/13
 * @ver: 1.0
 * @desc:
 */
@Service
public class AsyncTaskService implements IAsyncTaskService {
	@Override
	@Async
	public Future<Long> factorialCalculator(Integer number) {
		long result = 1L;
		if (number == 1 || number == 0) {
			return AsyncResult.forValue((long) number);
		}
		while (number > 1) {
			result = result * (long) number;
			number--;
		}
		return AsyncResult.forValue(result);
	}
}
