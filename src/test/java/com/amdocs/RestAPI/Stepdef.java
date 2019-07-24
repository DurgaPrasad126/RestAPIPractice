package com.amdocs.RestAPI;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.HttpURLConnection;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT, classes=RestApiApplication.class )
public class Stepdef {
	String url;
	HttpURLConnection restHttpConnection;
    double result=0;
	
	
	@Given("Rest API {string}")
	public void rest_API(String serviceUrl) throws IOException {
	    this.url = serviceUrl;
	}
	
	@When("I invoke the given rest api")
	public void i_invoke_the_given_rest_api() throws IOException {
		//restHttpConnection = (HttpURLConnection) url.openConnection();
		//restHttpConnection.setRequestMethod("GET");
		//restHttpConnection.connect();
		//restHttpConnection.getResponseCode();
	   RestTemplate restTemplate = new RestTemplate();
	   result = restTemplate.getForObject(url, Double.class);
	   
	
	
	}
	
	@Then("the expected sum is {int}")
	public void the_expected_sum_is(double expectedResult) {
	   assertEquals(expectedResult ,result,0.01);
		
	}



}
