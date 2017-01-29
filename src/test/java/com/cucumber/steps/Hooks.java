package com.cucumber.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import org.picocontainer.DefaultPicoContainer;

public class Hooks {
	
	private WebDriver driver;

	@Before
	public void beforeScenario() {
		this.driver = new ChromeDriver();
		driver.navigate().to("http://google.com");

//		DefaultPicoContainer pico = new DefaultPicoContainer();
//		pico.addComponent(driver.getClass());
//		pico.addComponent(ThreadPool.class, DefaultThreadPool.class);
//		pico.addComponent(MyComp.class, MyComp.class);
//
//		MyComp myComp = (MyComp)pico.getInstance(MyComp.class);
	}

	
	@After
	public void afterScenario() {
		driver.quit();
	}
}
