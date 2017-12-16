package com.jim.lock;

import org.omg.CORBA.MARSHAL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: liu jun
 * @date: 03:25 2017/12/11
 * @ver: 1.0
 * @desc:
 */
public class ExecutorsDemo implements Callable<Integer> {
	private static final Logger LOGGER = LoggerFactory.getLogger(ExecutorsDemo.class);

	private int START = 0;
	ExecutorsDemo (int i){
		this.START = i;
	}
	@Override
	public Integer call() throws Exception {
		START++;
		LOGGER.debug(Thread.currentThread().getName()+ "::" + String.valueOf(START));
		return START;
	}
}
