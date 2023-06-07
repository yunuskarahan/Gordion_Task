package com.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
        "html:target/cucumber-report.html",
        "json:target/cucumber.json",
        "rerun:target/rerun.txt",
        "me.jvt.cucumber.report.PrettyReports:target/cucumber",
},
        features = "src/test/resources/features",
        glue = "com/step_definitions",
        dryRun = false,
        tags = "",
        publish = false
)
public class CukesRunner {
}
