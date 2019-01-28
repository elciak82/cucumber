package com.udemy;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@qa1") //wszystkie pliki teature z tym tagiem
public class RunCucumberTest {
}