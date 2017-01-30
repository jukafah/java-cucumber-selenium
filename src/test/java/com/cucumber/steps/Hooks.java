package com.cucumber.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import cucumber.api.Scenario;

//import cucumber.api.picocontainer;

import org.picocontainer.DefaultPicoContainer;

public class Hooks {
	
	private WebDriver driver;

	@Before
	public void beforeScenario(Scenario scenario) {


	}

	
	@After
	public void afterScenario(Scenario scenario) {

	}
}
