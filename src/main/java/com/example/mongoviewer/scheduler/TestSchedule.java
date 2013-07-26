package com.example.mongoviewer.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TestSchedule {
	private static Logger logger = LoggerFactory.getLogger(TestSchedule.class);

	@Scheduled(fixedRate = 60000)
	public void greet() {
		logger.debug("task schedule");
	}

}
