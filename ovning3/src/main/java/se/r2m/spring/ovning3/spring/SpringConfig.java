package se.r2m.spring.ovning3.spring;

import java.util.zip.CRC32;
import java.util.zip.Checksum;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import se.r2m.spring.ovning3.bean.SpringChecksumCrc32Impl;
import se.r2m.spring.ovning3.bean.SpringChecksumAsync;

@EnableAsync
@Configuration
public class SpringConfig {

	@Bean
	public Checksum crc32() {
		return new CRC32();
	}
	
	@Bean
	@Lazy
	public SpringChecksumAsync checksum() {
		return new SpringChecksumCrc32Impl();
	}

	@Bean
	public TaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor executor = new org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor();
		executor.setCorePoolSize(4);
		return executor;
	}
}
