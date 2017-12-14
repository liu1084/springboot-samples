package com.jim.schedule;

import com.jim.schedule.config.ScheduleConfig;
import com.jim.schedule.model.service.IScheduleService;
import com.jim.schedule.model.service.ScheduleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * @author: liu jun
 * @date: 22:34 2017/12/13
 * @ver: 1.0
 * @desc:
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ScheduleServiceTest extends AbstractTestNGSpringContextTests {
	private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleServiceTest.class);
	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void testCronTask() {
		AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(ScheduleConfig.class);
	}
}
