Feature: Consultar el descubierto de una cuenta

  Scenario: Una cuenta que no uso su descubierto
    Given la cuenta "0000000001" tiene un saldo de 2000.00
    And un acuerdo en descubierto por 200.00 con interes de 2.5 %
    When consulto el limite para girar en  descubierto
    Then el resultado es 200.00
