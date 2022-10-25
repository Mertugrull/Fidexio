package com.cydeo.fidexio.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-report.html",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        },
        features = "src/test/resources/Features",
        glue = "com/cydeo/fidexio/step_definitions",
        dryRun = false,
        tags = " @FIDE-1416"

)

public class CukesRunner {

}
