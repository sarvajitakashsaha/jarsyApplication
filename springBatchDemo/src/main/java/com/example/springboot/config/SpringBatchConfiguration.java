package com.example.springboot.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.example.springboot.model.UserBatch;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfiguration {

	@Bean
	public Job job(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory,
			ItemReader<UserBatch> itemReader, ItemProcessor<UserBatch, UserBatch> itemProcessor,
			ItemWriter<UserBatch> itemWriter) {
		Step step = stepBuilderFactory.get("file_load").<UserBatch, UserBatch>chunk(100).reader(itemReader)
				.processor(itemProcessor).writer(itemWriter).build();

		Job job = jobBuilderFactory.get("demo_job").incrementer(new RunIdIncrementer()).start(step).build();
		return job;
	}

	@Bean
	public FlatFileItemReader<UserBatch> fileItemReader(@Value("${input}") Resource resource) {
		FlatFileItemReader<UserBatch> flatFileItemReader = new FlatFileItemReader<UserBatch>();
		flatFileItemReader.setResource(resource);
		flatFileItemReader.setName("csvReader");
		flatFileItemReader.setLinesToSkip(1);
		flatFileItemReader.setLineMapper(lineMapper());
		return flatFileItemReader;
	}

	@Bean
	LineMapper<UserBatch> lineMapper() {
		DefaultLineMapper<UserBatch> defaultLineMapper = new DefaultLineMapper<UserBatch>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames(new String[] { "id", "name", "dept", "salary" });
		BeanWrapperFieldSetMapper<UserBatch> fieldSetMapper = new BeanWrapperFieldSetMapper<UserBatch>();
		fieldSetMapper.setTargetType(UserBatch.class);
		defaultLineMapper.setLineTokenizer(lineTokenizer);
		defaultLineMapper.setFieldSetMapper(fieldSetMapper);
		return defaultLineMapper;
	}
}
