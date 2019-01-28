package com.udemy;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@dev") //tag do pliku .feature
        //features = "src/test/resources/com/udemy/dodaj_uzytkownika.feature") //sciezka do pliku feature
public class RunNowyUzytkownikTest {
}