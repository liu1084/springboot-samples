package com.jim.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: liu jun
 * @date: 02:56 2017/12/11
 * @ver: 1.0
 * @desc:
 */
public class MultiThreadJoin {
	private static int START = 0;
	private static final Logger LOGGER = LoggerFactory.getLogger(MultiThreadJoin.class);
	static class JobRunnable implements Runnable{
		@Override
		public void run() {
			START++;
			LOGGER.debug(Thread.currentThread().getName()+ "::" + String.valueOf(START));
		}
	}
}
