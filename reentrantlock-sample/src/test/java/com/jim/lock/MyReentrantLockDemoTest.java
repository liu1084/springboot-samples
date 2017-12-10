package com.jim.lock;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: liu jun
 * @date: 02:43 2017/12/11
 * @ver: 1.0
 * @desc:
 */
@Test
public class MyReentrantLockDemoTest {

	private volatile boolean isValid = false;
	CountDownLatch start = new CountDownLatch(1);
	CountDownLatch end = new CountDownLatch(2);

	@Test
	public void testReentrantLock(){
		ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10));

		for (int i =0; i < 2; i++){
			final int count = i;
			executor.execute(new Thread(new Runnable() {
				public void run() {
					Thread.currentThread().setName("Thread" + count);
					MyReentrantLockDemo myReentrantLockDemo = new MyReentrantLockDemo();
					myReentrantLockDemo.processCacheDownGrading(count);
				}
			}));
		}
	}
}
