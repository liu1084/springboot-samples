package com.jim.schedule.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author: liu jun
 * @date: 22:00 2017/12/13
 * @ver: 1.0
 * @desc:
 */
@Configuration
@EnableScheduling
@ComponentScan({"com.jim.schedule.model.service"})
public class ScheduleConfig {

}
