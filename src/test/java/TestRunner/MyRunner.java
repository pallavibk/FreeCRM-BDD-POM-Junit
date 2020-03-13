package TestRunner;


import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(glue= {"stepDefinitions"},features= {"src/test/resources/features/test.feature"},
dryRun=false,format={"html:target/cucumberResult.html"},
plugin= {
		"rerun:target/rerun.txt"})
public class MyRunner {

}

