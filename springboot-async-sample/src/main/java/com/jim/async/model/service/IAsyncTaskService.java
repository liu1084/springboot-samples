package com.jim.async.model.service;

import java.util.concurrent.Future;

/**
 * @author: liu jun
 * @date: 16:12 2017/12/13
 * @ver: 1.0
 * @desc:
 */
public interface IAsyncTaskService {
	Future<Long> factorialCalculator(Integer number);
}
