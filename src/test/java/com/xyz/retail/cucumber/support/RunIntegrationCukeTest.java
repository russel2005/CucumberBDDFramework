package com.vanguard.retail.cucumber;

import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import com.vanguard.shared.CucumberRunnerUtil;
import com.vanguard.test.categories.IntegrationTest;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@Category(IntegrationTest.class)
@RunWith(Cucumber.class)
@CucumberOptions(snippets = SnippetType.CAMELCASE, strict = false, monochrome = true, tags = { "@ManualTest" }, 
features = {CucumberRunnerUtil.CukeFormat.FEATURE_FILE_LOCATION},
glue = {"com.vanguard.shared.cucumber"},
plugin = {"pretty", CucumberRunnerUtil.CukeFormat.HTML_REPORT + "manual/manual-test-reports", 
		CucumberRunnerUtil.CukeFormat.JSON_RESULTS + "manual/manual-test-reports/manual-test-reports.json",
		CucumberRunnerUtil.CukeFormat.JUNIT_XML_REPORT + "manual/manual-test-reports/manual-test-reports.xml"})

public class RunIntegrationCukeTest {
	//This runner has been changed to intentionally run and generate a report for manual tests. 

}
