package org.glenn.exercise.primegen.controller;

import org.glenn.exercise.primegen.model.PrimesResponse;
import org.glenn.exercise.primegen.service.ParallelPrimeNumberStrategy;
import org.glenn.exercise.primegen.service.PrimeNumberStrategy;
import org.glenn.exercise.primegen.service.PrimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/primes")
public class PrimesController {

    private PrimeService primeService;

    @Autowired
    public PrimesController(final PrimeService primeService) {
        this.primeService = primeService;
    }

    @RequestMapping(value = "/{upperLimit}", method = RequestMethod.GET)
    @ResponseBody
    public PrimesResponse getPrimeNumbers(@PathVariable final int upperLimit, @RequestParam("method") final String method) {
    	
    	primeService.setStrategy(new PrimeNumberStrategy());
    	if (method.equals("parallel")) {
        	primeService.setStrategy(new ParallelPrimeNumberStrategy());    		
    	}
        final PrimesResponse primesResponse = new PrimesResponse(method, upperLimit, primeService.getPrimes(upperLimit));
        return primesResponse;
    }


}
