package com.jim.lock;

/**
 * @author: liu jun
 * @date: 00:03 2017/12/11
 * @ver: 1.0
 * @desc:
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 在多线程的情况下，一份缓存放在线程不安全的map中（如：HashMap),或者一个文件同时被多个线程读写，这个时候得到的数据可能并不是预期的值。
 * 当一个线程获得写锁的情况下，其他读、写的线程应该等待；
 * 当一个线程获得读锁的情况下，其他线程也可以读，但是拿到写锁的线程一个等待
 *
 * 通常我们想到的是synchronized去同步数据。。。但是这种场景下更好的解决方式是：使用读写锁
 * 读写锁有个很重要的概念是重入或者叫降级锁，以下为oracle官方的一段代码
 * 1）需要声明一个表示数据读写状态的boolean的tag，比如isValid，用volatile修饰，其他线程可见
 * 2）在读取数据之前，所以需要先获取读锁，此时isValid是false
 * 3）此时对数据进行写入，所以，释放读锁，获取写锁
 * 4）当取得写锁的时候，再次检查tag，如果此时数据依然是无效状态，对数据进行写入
 * 5）写入结束后，立刻获得读锁
 * 6）最后在finlly里面，释放写锁
 * 7）读取数据结束后，释放读锁
 *
 */
public class MyReentrantLockDemo {
	private volatile boolean isValid = false;
	private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private Lock readLock = readWriteLock.readLock();
	private Lock writeLock = readWriteLock.writeLock();
	private int currentValue = 0;

	public void processCacheDownGrading(int num){
		readLock.lock();
		if (!isValid){
			readLock.unlock();
			writeLock.lock();

			try{
				if (!isValid){
					currentValue = num;
					isValid = true;
					readLock.lock();
				}
			}finally {
				writeLock.unlock();
			}
		}

		try {
			System.out.println(currentValue);
		}finally {
			readLock.unlock();
		}
	}

}
