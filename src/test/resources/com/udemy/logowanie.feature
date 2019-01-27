Feature: Logowanie do aplikacji
  W tym pliku bedziemy testowac logowanie uzytkownika do aplikacji.
  Sekcja ta jest traktowana jako opis i nie wplywa na wykonanie testu.

  Scenario: Uzytkownik podaje prawidlowe dane logowania
    # given jest warunkiem wstępnym do przeprowadzenia testu
    Given Uzytkownik jest na stronie logowania
    # and opisuje dodatkowy warunek poczatkowy
    And Uzytkownik istnieje w bazie danych
    # when okresla akcje, ktora zostanie wykonana
    When Uzytkownik wprowadza poprawna nazwe uzytkownika i haslo
    # and opisuje dodatkową akcje
    And Uzytkownik klika przycisk Zaloguj
    # than opisuje wynik poprzednich krokow
    Then Uzytkownik zostaje zalogowany na strone domowa aplikacji
    # and opisuje dodatkowy oczekiwany wynik
    And Informacja o udanym logowaniu zostanie wyswietlona


  Scenario: Uzytkownik podaje bledny login
    Given Uzytkownik jest na stronie logowania
    And Uzytkownik istnieje w bazie danych
    When Uzytkownik wprowadza poprawna nazwe uzytkownika i bledne haslo
    And Uzytkownik klika przycisk Zaloguj
    Then Uzytkownik nie zostaje przekierowany na strone domowa aplikacji
    And Informacja o nieudanym logowaniu zostanie wyswietlona


  Scenario: Uzytkownik podaje bledne haslo
    Given Uzytkownik jest na stronie logowania
    And Uzytkownik istnieje w bazie danych
    When Uzytkownik wprowadza bledna nazwe uzytkownika i poprawne haslo
    And Uzytkownik klika przycisk Zaloguj
    Then Uzytkownik nie zostaje przekierowany na strone domowa aplikacji
    And Informacja o nieudanym logowaniu zostanie wyswietlona


  Scenario: Uzytkownik podaje bledne dane logowania
    Given Uzytkownik jest na stronie logowania
    And Uzytkownik istnieje w bazie danych
    When Uzytkownik wprowadza bledna nazwe uzytkownika i bledne haslo
    And Uzytkownik klika przycisk Zaloguj
    Then Uzytkownik nie zostaje przekierowany na strone domowa aplikacji
    And Informacja o nieudanym logowaniu zostanie wyswietlona
