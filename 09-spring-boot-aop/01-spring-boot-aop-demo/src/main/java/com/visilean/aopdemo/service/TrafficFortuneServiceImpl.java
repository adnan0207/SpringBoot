package com.visilean.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService {

	@Override
	public String getFortune() {

		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		return "Expect heavy traffic this morning";
	}

}
