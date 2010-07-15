package net.lucasward.sample;

import org.junit.Before;
import org.junit.Test;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.springframework.batch.core.BatchStatus.COMPLETED;

public class JobTest {

	JobLauncher jobLauncher;
	Job job;

	@Before
	public void setUp(){
		ApplicationContext context = new ClassPathXmlApplicationContext("jobs/sampleJob.xml");
		jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		job = (Job) context.getBean("sampleJob");
	}

	@Test
	public void jobShouldRunSuccessfully() throws JobInstanceAlreadyCompleteException, JobParametersInvalidException, JobRestartException, JobExecutionAlreadyRunningException {
		JobExecution jobExecution = jobLauncher.run(job, new JobParameters());
		assertEquals(COMPLETED, jobExecution.getStatus());
	}
}
