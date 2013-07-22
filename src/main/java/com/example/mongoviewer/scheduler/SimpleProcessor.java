package com.example.mongoviewer.scheduler;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SimpleProcessor {
	private static Logger logger = LoggerFactory.getLogger(SimpleProcessor.class);
	
	private final AtomicInteger counter = new AtomicInteger();

	public void process() {
		int i = counter.incrementAndGet();
		logger.debug("SimpleProcessor:[process] Passing through... " + i);
	}

}
