package org.glenn.exercise.primegen.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class ParallelPrimeNumberStrategy implements PrimeStrategy {

	@Override
	public List<Integer> getPrimeNumbers(int upperLimit) {
		
        IntStream stream = IntStream.iterate(2, n -> n + 1).limit(upperLimit-1).parallel()
                .filter(n -> IntStream.rangeClosed(2,(int)Math.sqrt(n)).parallel()
                        .noneMatch(k -> n % k == 0));
        
        return stream.boxed().collect(Collectors.toList());
	}
}
