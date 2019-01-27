package com.udemy;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import org.junit.Assert;

public class LogowanieSteps {
    private Logowanie logowanie;

    @Given("^Uzytkownik jest na stronie logowania$")
    public void uzytkownikJestNaStronieLogowania() {
        logowanie = new Logowanie(); //gdyby był to test wykonywany przy uzyciu selenium, tutaj bylaby metoda get driver
    }

    @And("^Uzytkownik o nazwie \"([^\"]*)\" i \"([^\"]*)\" istnieje w bazie danych$")
    public void uzytkownikONazwieIIstniejeWBazieDanych(String userName, String password) {
        logowanie.setUserInDataBase(userName, password);
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
    public void uzytkownikWprowadzaNazweUzytkownikaIHaslo(String userName, String password) {
        logowanie.logIn(userName, password);
    }

    @But("^Dane logowania są niepoprawne$")
    public void daneLogowaniaSąNiepoprawne() {
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
