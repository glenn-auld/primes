package org.glenn.exercise.primegen.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PrimeService {
	private PrimeStrategy strategy;

	public void setStrategy(PrimeStrategy strategy) {
		this.strategy = strategy;
	}
	
	public List<Integer> getPrimes(int upperLimit) {
		return strategy.getPrimeNumbers(upperLimit);
	}
}
