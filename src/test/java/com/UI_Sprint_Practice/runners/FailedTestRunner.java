package com.UI_Sprint_Practice.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/rerun.txt",
        glue = "com/UI_Sprint_Practice/step_definitions"
)
public class FailedTestRunner {
}


