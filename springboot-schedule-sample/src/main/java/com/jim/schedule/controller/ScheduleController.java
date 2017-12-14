package com.jim.schedule.controller;

import com.jim.schedule.config.ScheduleConfig;
import com.jim.schedule.model.service.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liu jun
 * @date: 22:38 2017/12/13
 * @ver: 1.0
 * @desc:
 */
@RestController
@RequestMapping(value = "/sch")
public class ScheduleController {
	@Autowired
	private IScheduleService scheduleService;

	@GetMapping("/cron")
	public void cron() {

	}
}
