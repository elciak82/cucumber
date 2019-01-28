@qa
Feature: Logowanie do aplikacji
  W tym pliku bedziemy testowac logowanie uzytkownika do aplikacji.
  Sekcja ta jest traktowana jako opis i nie wplywa na wykonanie testu.

  Background:
     # given jest warunkiem wstępnym do przeprowadzenia testu
    Given Uzytkownik jest na stronie logowania

  # Scenario Outline informuje ze test bedzie odpalany wiecej niz 1 raz. Pamietaj o Examples pod spodem!
  Scenario Outline: Uzytkownik podaje prawidlowe dane logowania
    # and opisuje dodatkowy warunek poczatkowy
    And Uzytkownik o nazwie "<login>" i "<haslo>" istnieje w bazie danych
    # when okresla akcje, ktora zostanie wykonana
    When Uzytkownik wprowadza nazwe uzytkownika "<login>" i haslo "<haslo>"
    # and opisuje dodatkową akcje
    And Uzytkownik klika przycisk Zaloguj
    # than opisuje wynik poprzednich krokow
    Then Uzytkownik zostaje zalogowany na strone domowa aplikacji
    # and opisuje dodatkowy oczekiwany wynik
    And Informacja o udanym logowaniu zostanie wyswietlona

    # podanie warości parametrów - forma tabelaryczna
    Examples:
    # wartosci parametrów w tescie (2 runy). Ten scenariusz odpali sie 2 razy. Parametry <login> i <haslo> zostana zastapione przez wartości z Examples
    |login|haslo|
    |login1|haslo1|
    |login2|haslo2|


  Scenario: Uzytkownik podaje bledny login
    And Uzytkownik o nazwie "login2" i "haslo2" istnieje w bazie danych
    When Uzytkownik wprowadza nazwe uzytkownika "zlylogin" i haslo "haslo2"
    And Uzytkownik klika przycisk Zaloguj
    # but umozliwia dodanie negatywnego komentarza, uzywany do negatywnych warunkow
    But Dane logowania są niepoprawne
    Then Uzytkownik nie zostaje przekierowany na strone domowa aplikacji
    And Informacja o nieudanym logowaniu zostanie wyswietlona


  Scenario: Uzytkownik podaje bledne haslo
    And Uzytkownik o nazwie "login3" i "haslo3" istnieje w bazie danych
    When Uzytkownik wprowadza nazwe uzytkownika "login3" i haslo "zlehaslo"
    And Uzytkownik klika przycisk Zaloguj
    But Dane logowania są niepoprawne
    Then Uzytkownik nie zostaje przekierowany na strone domowa aplikacji
    And Informacja o nieudanym logowaniu zostanie wyswietlona


  Scenario: Uzytkownik podaje bledne dane logowania
    And Uzytkownik o nazwie "login4" i "haslo4" istnieje w bazie danych
    When Uzytkownik wprowadza nazwe uzytkownika "zlylogin" i haslo "złehaslo"
    And Uzytkownik klika przycisk Zaloguj
    But Dane logowania są niepoprawne
    Then Uzytkownik nie zostaje przekierowany na strone domowa aplikacji
    And Informacja o nieudanym logowaniu zostanie wyswietlona
