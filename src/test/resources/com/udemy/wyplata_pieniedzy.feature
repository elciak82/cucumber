Feature: Wyplata pieniedzy z bankomatu
  Scenario: Proba wyplacenia wiekszej ilosci pieniedzy niz saldo konta

    Given Konto z saldem 200 zł
    When Uzytkownik probuje wyplacic 300 zl
    Then Saldo nie zmienia sie i wynosi 200 zl
