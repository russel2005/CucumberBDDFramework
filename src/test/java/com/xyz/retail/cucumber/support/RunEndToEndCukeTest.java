package com.xyz.retail.cucumber;

import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import com.vanguard.shared.CucumberRunnerUtil;
import com.vanguard.test.categories.EndToEndTest;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@Category(EndToEndTest.class)
@RunWith(Cucumber.class)
@CucumberOptions(snippets = SnippetType.CAMELCASE, strict = true, monochrome = true, tags = { "@EndToEndTest,@CostBasis-GiftedShares"}, 
features = {CucumberRunnerUtil.CukeFormat.FEATURE_FILE_LOCATION},	
glue = {"com.vanguard.retail.cucumber", "com.vanguard.cucumber.selenium.hooks"},
plugin = {"pretty", CucumberRunnerUtil.CukeFormat.HTML_REPORT_ENDTOEND, 
		CucumberRunnerUtil.CukeFormat.JSON_RESULTS_ENDTOEND + "endtoend-test-reports.json",
		CucumberRunnerUtil.CukeFormat.JUNIT_XML_REPORT_ENDTOEND + "endtoend-test-reports.xml"})

public class RunEndToEndCukeTest {

}
