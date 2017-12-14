package com.jim.schedule.model.service;

import com.jim.schedule.config.ScheduleConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

/**
 * @author: liu jun
 * @date: 22:04 2017/12/13
 * @ver: 1.0
 * @desc:
 */
@Service
@PropertySource("classpath:schedule/time.properties")
public class ScheduleService implements  IScheduleService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleService.class);
	private final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	//@Scheduled(cron = "0/3 15 0 1 * ?")
	@Override
	public void cronTask() {
		LOGGER.debug(sdf.format(System.currentTimeMillis()));

	}

	//@Scheduled(fixedDelay = 3000)
	@Override
	public void fixedDelayTask() {
		LOGGER.debug(sdf.format(System.currentTimeMillis()));
	}

	@Override
	//@Scheduled(fixedRate = 500)
	public void fixedRate() {
		LOGGER.debug(sdf.format(System.currentTimeMillis()));
	}

	@Override
	//@Scheduled(initialDelay = 5000, fixedDelay = 500)
	public void initialDelayTask() {
		LOGGER.debug(sdf.format(System.currentTimeMillis()));
	}

	@Override
	//@Scheduled(fixedDelayString = "${fixedDelay}")
	public void fixedDelayStringTask() {
		LOGGER.debug(sdf.format(System.currentTimeMillis()));
	}

	@Override
	@Scheduled(fixedRateString = "${fixedRate}")
	public void fixedRateStringTask() {
		LOGGER.debug(sdf.format(System.currentTimeMillis()));
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScheduleConfig.class);

	}
}
