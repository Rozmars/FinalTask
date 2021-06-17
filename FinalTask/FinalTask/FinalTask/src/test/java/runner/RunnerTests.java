package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/resources",
        glue = {"stepdefinitions"}
)
public class RunnerTests extends AbstractTestNGCucumberTests {
}
