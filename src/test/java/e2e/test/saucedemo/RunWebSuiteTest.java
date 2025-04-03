package e2e.test.saucedemo;

import org.junit.runner.RunWith;
import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * The TestRunner File uses the @RunWith() Annotation for JUnit to execute
 */
@RunWith(Cucumber.class)

/**
 * 
 * 
 * The @CucumberOptions Annotation is used to define the location of feature,
 * files,stepdefinitions,reporting integration
 */
@CucumberOptions(features = { "src/spec/features" },
                  plugin = { "pretty","html:target/cucumber-report.html", "json:target/cucumber.json" },
                 glue = {"" }, 
                 tags = (""), monochrome = false, snippets = CAMELCASE

)

public class RunWebSuiteTest {

}
