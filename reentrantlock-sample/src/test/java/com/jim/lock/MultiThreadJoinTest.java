package com.jim.lock;

import org.testng.annotations.Test;

/**
 * @author: liu jun
 * @date: 03:08 2017/12/11
 * @ver: 1.0
 * @desc:
 */
@Test
public class MultiThreadJoinTest {

	@Test
	public void testJoin() throws InterruptedException {
		MultiThreadJoin.JobRunnable jobRunnable = new MultiThreadJoin.JobRunnable();
		Thread thread1 = new Thread(jobRunnable);
		Thread thread2 = new Thread(jobRunnable);
		thread1.setName("thread1");
		thread2.setName("thread2");
		thread1.start();
		thread2.start();
		thread1.join();
	}
}
