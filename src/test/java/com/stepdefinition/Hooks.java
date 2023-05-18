package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;
import BaseClass.BaseClass2;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass2 {

	@Before
	public void beforeScenario() throws FileNotFoundException, IOException {
		getDriver(getpropertyfileValue("browser"));
		browserlaunch(getpropertyfileValue("url"));
		maximizeWindow();
		implicitlyWait(20);

	}

	@After
	public void afterScenario(Scenario scenario) {
		scenario.attach(screenshot(), "image/png", "EveryScenario");
		quitMethod();
	}

}
