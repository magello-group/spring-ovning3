package se.r2m.spring.ovning3.bean;

import java.util.concurrent.Future;
import java.util.zip.Checksum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;

public class SpringChecksumCrc32Impl implements SpringChecksumAsync {
	
	@Autowired
	private Checksum checksum;

	public Checksum getChecksum() {
		return checksum;
	}

	public void setChecksum(Checksum checksum) {
		this.checksum = checksum;
	}
	
	@Async
	public Future<Long> printHashAsync(String input, long sleep) {
		try {
			Thread.sleep(sleep);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		byte bytes[] = input.getBytes();
		checksum.update(bytes, 0, bytes.length);
		long checksumValue = checksum.getValue();
		System.out.println(input + " har CRC32 " + checksumValue);
		return new AsyncResult<Long>(checksumValue);
	}

	public void printHashForwardAndBackward(String input) {
		String inputReverse = new StringBuilder(input).reverse().toString();
		System.out.println(String.format("'%s' bör skrivas ut före '%s'", inputReverse, input));
		printHashAsync(input, 1000);
		printHashAsync(inputReverse, 500);
	}

}
