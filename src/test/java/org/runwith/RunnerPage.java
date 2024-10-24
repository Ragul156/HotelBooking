package org.runwith;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\Feature\\LoginPage.feature",glue="org.step",
snippets=SnippetType.CAMELCASE,monochrome=true,dryRun=false)
public class RunnerPage {

}
