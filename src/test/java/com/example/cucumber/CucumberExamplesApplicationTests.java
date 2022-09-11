package com.example.cucumber;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.ConfigurationParameters;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
/** Created by qdd on 2022/4/22. */
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("is_it_friday_yet.feature")
@ConfigurationParameters({
  //    @ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "packagename.cucumber"),
  //    @ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@Example"),
  //    @ConfigurationParameter(key = JUNIT_PLATFORM_NAMING_STRATEGY_PROPERTY_NAME, value = "long"),
  //    @ConfigurationParameter(key = PLUGIN_PUBLISH_QUIET_PROPERTY_NAME, value = "true"),
  @ConfigurationParameter(
      key = PLUGIN_PROPERTY_NAME,
      value = "pretty, html:target/cucumber/cucumber.html"),
})
class CucumberExamplesApplicationTests {}
