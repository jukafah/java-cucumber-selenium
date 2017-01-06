package com.cucumber.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	public WebDriver driver;

	@Before
	public void beforeScenario() {
		System.out.println("Before Scenario");
		
		driver = new ChromeDriver();
		driver.navigate().to("http://google.com");
		
	}

	
	@After
	public void afterScenario() {
		System.out.println("After Scenario");
	}
}
