package org.glenn.exercise.primegen.error;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.glenn.exercise.primegen.PrimeNumbersApplication;
import org.glenn.exercise.primegen.errors.ApiError;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PrimeNumbersApplication.class)
@WebAppConfiguration
public class ErrorHandlingTest {

	
    @Test
    public void whenMethodArgumentMismatch_thenBadRequest() {
        final Response response = RestAssured.given().get("http://localhost:8181/primes/abc");
        final ApiError error = response.as(ApiError.class);
        assertEquals(HttpStatus.BAD_REQUEST, error.getStatus());
        assertEquals(1, error.getErrors().size());
        assertTrue(error.getErrors().get(0).contains("should be of type"));
    }

    @Test
    public void whenNoHandlerForHttpRequest_thenNotFound() {
        final Response response = RestAssured.given().get("http://localhost:8181/prime");
        final ApiError error = response.as(ApiError.class);
        assertEquals(HttpStatus.NOT_FOUND, error.getStatus());
        assertEquals(1, error.getErrors().size());
        assertTrue(error.getErrors().get(0).contains("No handler found"));
        System.out.println(response.asString());

    }

    @Test
    public void whenHttpRequestMethodNotSupported_thenMethodNotAllowed() {
        final Response response = RestAssured.given().delete("http://localhost:8181/primes/10");
        final ApiError error = response.as(ApiError.class);
        assertEquals(HttpStatus.METHOD_NOT_ALLOWED, error.getStatus());
        assertEquals(1, error.getErrors().size());
        assertTrue(error.getErrors().get(0).contains("Supported methods are"));
        System.out.println(response.asString());

    }

 /*   @Test
    public void whenSendInvalidHttpMediaType_thenUnsupportedMediaType() {
        final Response response = RestAssured.given().body("").post("http://localhost:8181/primes");
        final ApiError error = response.as(ApiError.class);
        assertEquals(HttpStatus.UNSUPPORTED_MEDIA_TYPE, error.getStatus());
        assertEquals(1, error.getErrors().size());
        assertTrue(error.getErrors().get(0).contains("media type is not supported"));
        System.out.println(response.asString());

    }*/

}
