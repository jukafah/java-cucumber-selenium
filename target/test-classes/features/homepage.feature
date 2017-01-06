Feature: Homepage

@C001 @smoke-test
Scenario: Homepage displays header "We test software"
	Given I am on "http://tapqa.com"
	Then I see the header
	    """
	    We test software
	    """
