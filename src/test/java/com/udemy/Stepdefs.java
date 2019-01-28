package com.udemy;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs {

    @Before
    public void setUp(){
        System.out.println("Metoda wykonana przed scenariuszem");
    }

    @Given("Konto z saldem 200 zł")
    public void kontoZSaldem(){
        System.out.println("Metoda Given - konto z saldem.\n");

    }

    @When("Uzytkownik probuje wyplacic 300 zl")
    public void wyplataZKonta(){
        System.out.println("Metoda When - wyplata z konta.\n");

    }

    @Then("Saldo nie zmienia sie i wynosi 200 zl")
    public void sprawdzenieSalda(){
        System.out.println("Metoda Then - sprawdzenie salda.\n");

    }

    @After
    public void tearDown(){
        System.out.println("Metoda wykonana po scenariuszu");
    }
}