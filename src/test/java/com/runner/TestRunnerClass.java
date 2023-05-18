package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@Login",
features = "src\\test\\resources\\Features", 
glue = "com\\stepdefinition", 
dryRun = false,
monochrome = true,
stepNotifications = true,
plugin="pretty")

public class TestRunnerClass {

}
