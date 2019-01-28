package com.udemy;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Map;

public class NowyUzytkownikSteps {


    @Given("^Uzytkownik jest na stronie formularza dodawania nowego uzytkownika$")
    public void uzytkownikJestNaStronieFormularzaDodawaniaNowegoUzytkownika() {
        System.out.println("Jestem na stronie formularza rejestracji nowego uzytkownika.");
    }

    @When("^Wporwadza poprawne dane do formularza$")
    public void wporwadzaPoprawneDaneDoFormularza(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class); //mapowanie SPRAWDZ!
        System.out.println("Imie " + data.get("imie")); //PIERWSZA KOLUMNA TO WARTOSC KLUCZA
        System.out.println("Nazwisko " + data.get("nazwisko"));
        System.out.println("Miasto " + data.get("miasto"));
        System.out.println("Ulica " + data.get("ulica"));
    }

    @Then("^Informacja o dodaniu uzytkownika pojawia sie na ekranie$")
    public void informacjaODodaniuUzytkownikaPojawiaSieNaEkranie() {
        System.out.println("Dodano nowego uzytkownika.");
    }
}
