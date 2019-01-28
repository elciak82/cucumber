# tag - oznaczenie
@dev
Feature: Dodawanie uzytkownika

  Scenario Outline: Dodawanie uzytkownika z poprawnymi danymi

    Given Uzytkownik jest na stronie formularza dodawania nowego uzytkownika
    When Wporwadza poprawne dane do formularza
    |imie|<imie>|
    |nazwisko|<nazwisko>|
    |miasto|<miasto>|
    |ulica|<ulica>|
    Then Informacja o dodaniu uzytkownika pojawia sie na ekranie

    Examples:
    |imie|nazwisko|miasto|ulica|
    |Ewelina|Walczak|Rybnik|Gliwicka|
    |Mateusz|Walczak|Sumina|Rybnicka|