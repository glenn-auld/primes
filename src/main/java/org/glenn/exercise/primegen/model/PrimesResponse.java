package org.glenn.exercise.primegen.model;

import java.io.Serializable;
import java.util.List;


public class PrimesResponse implements Serializable {

    private static final long serialVersionUID = 1746127840105174833L;

    private final String method;
    private final int ceiling;
    private final List<Integer> primes;

    public PrimesResponse(String method, int ceiling, List<Integer> primes) {
        this.ceiling = ceiling;
        this.primes = primes;
        this.method = method;
    }
   
    public String getMethod() {
		return method;
	}

	public int getCeiling() {
        return ceiling;
    }

    public List<Integer> getPrimes() {
        return primes;
    }
}
