package com.cucumber.steps;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",
				 format = { "pretty",
						 	"html:target/cucumber-html-report" },
				 tags = {})
public class Runner {

}
