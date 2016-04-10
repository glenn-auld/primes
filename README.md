# RESTful prime number generation

* Spring Boot based implementation which generates JSON responses for generated primes and exception handling.
* Exception handling is global (via a custom exception handler class)
* Has two methods of prime number generation: basic and parallel, implemented via the Strategy design pattern
* The parallel method is based on Java 1.8 streaming
* Test code exists for the controller, service and error handling (run these tests when the application is running)

Usage: http://localhost:8181/primes/{ceiling}/?method={method}

Where the ceiling is the highest possible prime number of the generated series
and method is type of generator to use. The simple/basic generator is default, for parallel use ?method=parallel

Response for a correctly formed request will be similar to:

{"method":"parallel","ceiling":20,"primes":[2,3,5,7,11,13,17,19]}
