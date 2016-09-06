package com.example.config;

import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;


@Configuration
@EnableScheduling
public class SchedulerConfig {

	
	@Bean
	public TaskScheduler concurrentTaskScheduler(){
		ConcurrentTaskScheduler concurrentTaskScheduler = new ConcurrentTaskScheduler();
		concurrentTaskScheduler.setScheduledExecutor(Executors.newScheduledThreadPool(10));
		return concurrentTaskScheduler;
	}
	
	
	
}
