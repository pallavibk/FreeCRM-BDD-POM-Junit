package TestRunner;


import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;


import cucumber.api.CucumberOptions;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(//jsonReport="target/cucumber.json",
retryCount=3
//,detailedReport=true,
//detailedAggregatedReport=true,
//overviewReport=true,
//coverageReport=true,
//jsonUsageReport="target/cucumber-usage.json",
//usageReport=true
//,toPDF=true,
//,excludeCoverageTags={""},
//includeCoverageTags= {"@chrome"},
//outputFolder="target"
)
@CucumberOptions(glue= {"stepDefinitions"},features= {"src/test/resources/features/login.feature"},
dryRun=false,format={"html:target/cucumberResult.html"},
plugin= {//"pretty:STDOUT",
		//"json:target/cucumber.json",
		//"usage:target/cucumber-usage.json",
		//"junit:target/cucumber-results.xml",
		"rerun:target/rerun.txt"})
public class Runner {

}

