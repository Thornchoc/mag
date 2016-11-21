package com.thorntons.acceptancetests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(glue = { "io.magentys.cinnamon", "com.thorntons" }, features = "src/test/resources/features", format = { "pretty",
        "json:target/cucumber-reports/cucumber.json" }, tags = { "@store_search" })
public class DevTests {
}
