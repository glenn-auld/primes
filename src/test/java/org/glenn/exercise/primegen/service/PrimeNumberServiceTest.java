package org.glenn.exercise.primegen.service;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

public class PrimeNumberServiceTest {

    private final PrimeService primeNumberService = new PrimeService();

    @Before
    public void initialise() {
    	primeNumberService.setStrategy(new PrimeNumberStrategy());
    }
      
    @Test
    public void testGetPrimeNumbersUpTo10() throws Exception {

        // when
        final List<Integer> primeNumbers = primeNumberService.getPrimes(10);

        // Then
        assertThat(primeNumbers).containsSequence(2,3,5,7);
    }

    @Test
    public void testGetPrimeNumbersUpTo10ParallelMethod() throws Exception {
    	primeNumberService.setStrategy(new ParallelPrimeNumberStrategy());
        // when
        final List<Integer> primeNumbers = primeNumberService.getPrimes(10);

        // Then
        assertThat(primeNumbers).hasSize(4);
        assertThat(primeNumbers).containsSequence(2,3,5,7);
    }
    
    @Test
    public void gettingPrimeNumbersForIntLessThanTwoShouldReturnEmptyList() {
        // when
        final List<Integer> primeNumbers = primeNumberService.getPrimes(1);

        // Then
        assertThat(primeNumbers).isEmpty();
    }

    @Test
    public void gettingPrimeNumbersForIntTwoShouldIncludeTwo() {
        // when
        final List<Integer> primeNumbers = primeNumberService.getPrimes(2);

        // Then
        assertThat(primeNumbers).hasSize(1).containsExactly(2);
    }

    @Test
    public void gettingPrimeNumbersShouldIncludeUpperLimit() {
        // when
        final List<Integer> primeNumbers = primeNumberService.getPrimes(11);

        // Then
        assertThat(primeNumbers).containsSequence(2,3,5,7, 11);
    }
    
    @Test
    public void gettingPrimeNumbersShouldIncludeUpperLimitParallel() {
       	primeNumberService.setStrategy(new ParallelPrimeNumberStrategy());
        
        // when
        final List<Integer> primeNumbers = primeNumberService.getPrimes(11);

        // Then
        assertThat(primeNumbers).containsSequence(2,3,5,7, 11);
    }

    @Test
    public void shouldBeAbleToGetPrimeNumbersForALargerUpperLimit() {
        // when
        final List<Integer> primeNumbers = primeNumberService.getPrimes(10000000);

        // Then
        assertThat(primeNumbers).hasSize(664579);
    }
}