package se.r2m.spring.ovning3.bean;

import java.util.concurrent.Future;


public interface SpringChecksumAsync {

	public Future<Long> printHashAsync(String input, long sleep);
	public void printHashForwardAndBackward(String input);

}