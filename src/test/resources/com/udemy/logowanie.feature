Feature: Logowanie do aplikacji
  W tym pliku bedziemy testowac logowanie uzytkownika do aplikacji.
  Sekcja ta jest traktowana jako opis i nie wplywa na wykonanie testu.

  Scenario: Uzytkownik podaje prawidlowe dane logowania
    # given jest warunkiem wstępnym do przeprowadzenia testu
    Given Uzytkownik jest na stronie logowania
    # and opisuje dodatkowy warunek poczatkowy
    And Uzytkownik o nazwie "login1" i "haslo1" istnieje w bazie danych
    # when okresla akcje, ktora zostanie wykonana
    When Uzytkownik wprowadza nazwe uzytkownika "login1" i haslo "haslo1"
    # and opisuje dodatkową akcje
    And Uzytkownik klika przycisk Zaloguj
    # than opisuje wynik poprzednich krokow
    Then Uzytkownik zostaje zalogowany na strone domowa aplikacji
    # and opisuje dodatkowy oczekiwany wynik
    And Informacja o udanym logowaniu zostanie wyswietlona


  Scenario: Uzytkownik podaje bledny login
    Given Uzytkownik jest na stronie logowania
    And Uzytkownik o nazwie "login2" i "haslo2" istnieje w bazie danych
    When Uzytkownik wprowadza nazwe uzytkownika "zlylogin" i haslo "haslo2"
    And Uzytkownik klika przycisk Zaloguj
    # but umozliwia dodanie negatywnego komentarza, uzywany do negatywnych warunkow
    But Dane logowania są niepoprawne
    Then Uzytkownik nie zostaje przekierowany na strone domowa aplikacji
    And Informacja o nieudanym logowaniu zostanie wyswietlona


  Scenario: Uzytkownik podaje bledne haslo
    Given Uzytkownik jest na stronie logowania
    And Uzytkownik o nazwie "login3" i "haslo3" istnieje w bazie danych
    When Uzytkownik wprowadza nazwe uzytkownika "login3" i haslo "zlehaslo"
    And Uzytkownik klika przycisk Zaloguj
    But Dane logowania są niepoprawne
    Then Uzytkownik nie zostaje przekierowany na strone domowa aplikacji
    And Informacja o nieudanym logowaniu zostanie wyswietlona


  Scenario: Uzytkownik podaje bledne dane logowania
    Given Uzytkownik jest na stronie logowania
    And Uzytkownik o nazwie "login4" i "haslo4" istnieje w bazie danych
    When Uzytkownik wprowadza nazwe uzytkownika "zlylogin" i haslo "zlehaslo"
    And Uzytkownik klika przycisk Zaloguj
    But Dane logowania są niepoprawne
    Then Uzytkownik nie zostaje przekierowany na strone domowa aplikacji
    And Informacja o nieudanym logowaniu zostanie wyswietlona
