package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/Features",tags={"@Addplace"},
glue="StepDefinition",plugin="json:target/jsonReports/cucumber-report.json"
		)
	
public class TestRunner {

}
