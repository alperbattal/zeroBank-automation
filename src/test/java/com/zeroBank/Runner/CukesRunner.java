package com.zeroBank.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features", //path to features
        glue = "com/zeroBank/stepDefinitions",//path to step definitions
        dryRun =false,
        tags = "@pay_bills",
        plugin = {"html:target/default-cucumber-reports",
                "json:target/cucumber.json"
        }
)
public class CukesRunner {

}



