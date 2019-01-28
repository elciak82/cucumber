Feature: Dodawanie uzytkownika

  Scenario: Dodawanie uzytkownika z poprawnymi danymi

    Given Uzytkownik jest na stronie formularza dodawania nowego uzytkownika
    When Wporwadza poprawne dane do formularza
    |imie|Ewelina|
    |nazwisko|Walczak|
    |miasto|Rybnik|
    |ulica|Gliwicka|
    Then Informacja o dodaniu uzytkownika pojawia sie na ekranie