package org.glenn.exercise.primegen.service;

import java.util.List;


public interface PrimeStrategy {

    List<Integer> getPrimeNumbers(int upperLimit);
}
