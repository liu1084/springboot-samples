package com.jim.lock;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author: liu jun
 * @date: 03:34 2017/12/11
 * @ver: 1.0
 * @desc:
 */
@Test
public class ExecutorsDemoTest {
	private static final int MAX_THRERAD_NUM = 10;
	private ExecutorService executorService = Executors.newFixedThreadPool(MAX_THRERAD_NUM);
	private List<Future<Integer>> results = new ArrayList<>();
	@Test
	public void testExecutors() throws InterruptedException, ExecutionException {
		for (int i = 0; i < MAX_THRERAD_NUM; i++){
			ExecutorsDemo executorsDemo = new ExecutorsDemo(i);
			Future<Integer> future = executorService.submit(executorsDemo);
			results.add(future);
		}

		for (Future<Integer> future : results){
			System.out.println(future.get());
		}
	}
}
