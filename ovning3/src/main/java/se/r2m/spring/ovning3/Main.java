package se.r2m.spring.ovning3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import se.r2m.spring.ovning3.bean.SpringChecksumAsync;
import se.r2m.spring.ovning3.spring.SpringConfig;

import com.google.common.base.Joiner;

public class Main {

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class)) {
			System.out.println("ApplicationContext: " + ctx);
			if (args.length < 1) {
				System.out.println("Användning: crc32checksum <sträng>");
				return;
			}
			String input = Joiner.on(" ").join(args);
			SpringChecksumAsync checksum = ctx.getBean(SpringChecksumAsync.class);
			checksum.printHashForwardAndBackward(input);
			Thread.sleep(60_000);
		}
	}
}
