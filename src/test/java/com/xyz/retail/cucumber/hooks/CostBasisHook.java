package com.xyz.retail.cucumber.hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import com.vanguard.cucumber.selenium.hooks.CucumberTestSetup;
import com.vanguard.selenium.inner.core.utils.LoggingUtility;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class CostBasisHook {

	@Autowired
	public CucumberTestSetup testSetup;
	public static byte[] screenshot = null;
	public static Scenario stepInScenario;

	@Before
	public void before(Scenario scenario) {
		stepInScenario = scenario;
		LoggingUtility.logInfo("Executing Scenario: " + scenario.getName().toUpperCase());
	}
	
	@After
	public void screenshot(Scenario scenario) {
		try {
			if (scenario.getStatus().equalsIgnoreCase("passed")) {
				screenshot = ((TakesScreenshot) testSetup.driver()).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			}
		} catch (Exception e) {
			LoggingUtility.logError("EXCEPTION WHILE TAKING / SAVING / EMBEDDING SCREEN SHOT");
			LoggingUtility.logError("EXCEPTION : " + e);
		}
	}

}
