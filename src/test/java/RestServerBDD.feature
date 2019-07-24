Feature: Creating REST API Application
	Scenario: Invoking Addition 
		Given Rest API "http://localhost:9400/addition?firstOperand=10&secondOperand=10"
		When I invoke the given rest api
		Then the expected sum is 20
