package com.jim.schedule.model.service;

/**
 * @author: liu jun
 * @date: 22:02 2017/12/13
 * @ver: 1.0
 * @desc:
 */
public interface IScheduleService {
	void cronTask();
	void fixedDelayTask();
	void fixedRate();
	void initialDelayTask();
	void fixedDelayStringTask();
	void fixedRateStringTask();
}
