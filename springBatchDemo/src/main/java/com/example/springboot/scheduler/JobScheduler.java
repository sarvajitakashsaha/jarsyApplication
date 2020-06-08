package com.example.springboot.scheduler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;

@Configuration
public class JobScheduler {

	@Autowired
	JobLauncher jobLauncher;
	@Autowired
	Job job;

	@Scheduled(cron = "0 0/1 * 1/1 * ?")
	public BatchStatus load() throws JobParametersInvalidException, JobExecutionAlreadyRunningException,
			JobRestartException, JobInstanceAlreadyCompleteException {

		System.out.println("job triggered");
		Map<String, JobParameter> maps = new HashMap<>();
		maps.put("time", new JobParameter(System.currentTimeMillis()));
		JobParameters parameters = new JobParameters(maps);
		JobExecution jobExecution = jobLauncher.run(job, parameters);

		System.out.println("JobExecution: " + jobExecution.getStatus());

		System.out.println("Batch is Running...");
		while (jobExecution.isRunning()) {
			System.out.println("...");
		}

		return jobExecution.getStatus();
	}

}
