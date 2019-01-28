package com.udemy;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import org.junit.Assert;

public class LogowanieSteps {
    private Logowanie logowanie;
    private String userName; //zdefiniowanie pól
    private String password; //zdefiniowanie pól

    @Given("^Uzytkownik jest na stronie logowania$")
    public void uzytkownikJestNaStronieLogowania() {
        logowanie = new Logowanie(); //gdyby był to test wykonywany przy uzyciu selenium, tutaj bylaby metoda get driver
    }

    @And("^Uzytkownik o nazwie \"([^\"]*)\" i \"([^\"]*)\" istnieje w bazie danych$")
    public void uzytkownikONazwieIIstniejeWBazieDanych(String login, String haslo) {
        System.out.println("Uzytkownik podaje login: " + login + " i haslo: " + haslo); // drukowanie loginu i hasla (te podane w Example)
        this.userName = login; //w tych polach bedziemy przechowywac dane uzytkownika
        this.password = haslo;
        logowanie.setUserInDataBase(login, haslo);
    }

    @And("^Uzytkownik klika przycisk Zaloguj$")
    public void uzytkownikKlikaPrzyciskZaloguj() {
        System.out.println("Klikamy przycisk logowania.");
    }

    @Then("^Uzytkownik zostaje zalogowany na strone domowa aplikacji$")
    public void uzytkownikZostajeZalogowanyNaStroneDomowaAplikacji() {
        Assert.assertTrue(logowanie.isLoggedIn());
    }

    @And("^Informacja o udanym logowaniu zostanie wyswietlona$")
    public void informacjaOUdanymLogowaniuZostanieWyswietlona() {
        Assert.assertTrue(logowanie.getMsg().equals("Udalo Ci sie zalogowac!"));
    }

    @When("^Uzytkownik wprowadza nazwe uzytkownika \"([^\"]*)\" i haslo \"([^\"]*)\"$")
    public void uzytkownikWprowadzaNazweUzytkownikaIHaslo(String login, String haslo) {
        this.userName = login; //w tych polach bedziemy przechowywac dane uzyte podczas logowania żeby mieć dostep do tych wartosci z innych metod
        this.password = haslo;
        logowanie.logIn(login, haslo);
    }

    @But("^Dane logowania są niepoprawne$")
    public void daneLogowaniaSąNiepoprawne() {
        //tutaj porownamy dane. username i password to zmienne zdefiniowane w klasie, dlatego mozna ich tutaj uzyc
        String databaseUsername = logowanie.getCurrentUserName();
        String databasePassword= logowanie.getCurrentPassword();
        Assert.assertFalse(userName.equals(databaseUsername) && (password.equals(databasePassword)));
    }

    @Then("^Uzytkownik nie zostaje przekierowany na strone domowa aplikacji$")
    public void uzytkownikNieZostajePrzekierowanyNaStroneDomowaAplikacji() {
        Assert.assertFalse(logowanie.isLoggedIn());
    }

    @And("^Informacja o nieudanym logowaniu zostanie wyswietlona$")
    public void informacjaONieudanymLogowaniuZostanieWyswietlona() {
        Assert.assertTrue(logowanie.getMsg().equals("Nie ualo Ci sie zalogowac!"));
    }

}
