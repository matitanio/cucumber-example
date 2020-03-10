Feature: Extraer Dinero de una caja de ahorro

  Scenario: Extraer de una cuenta con Saldo
    Given una cuenta tiene un saldo de 2000.00
    When Extraigo 300.00 en la cuenta
    Then El saldo de mi cuenta es de 1700.00
    And Tengo el movimiento de extraccion por 300.00 en mi lista de movimientos

  Scenario: Extraer de una cuenta sin acuerdo con Saldo insuficiente
    Given una cuenta tiene un saldo de 300.00
    And no tiene acuerdo
    When Intengo extraer 500.00
    And El saldo de mi cuenta es de 300.00

  Scenario: Extraer de una cuenta con Saldo y que usa el acuerdo
    Given una cuenta tiene un saldo de 300.00
    And un acuerdo en descubierto por 2000.00 con interes de 2.5 %
    When Extraigo 500.00 en la cuenta
    Then El saldo de mi cuenta es de -200.00
    And Tengo el movimiento de extraccion por 500.00 en mi lista de movimientos

  Scenario: Extraer de una cuenta que uso el acuerdo y tiene saldo insuficiente
    Given una cuenta tiene un saldo de -800.00
    And un acuerdo en descubierto por 2000.00 con interes de 2.5 %
    When Intengo extraer 1500.00
    Then El saldo de mi cuenta es de -800.00

  Scenario: Extraer de una cuenta con dos acuerdos
    Given una cuenta tiene un saldo de -800.00
    And un acuerdo en descubierto por 2000.00 con interes de 2.5 %
    And un acuerdo en descubierto por 10000.00 con interes de 2.5 %
    When Extraigo 1500.00 en la cuenta
    Then El saldo de mi cuenta es de -2300.00
    And Tengo el movimiento de extraccion por 1500.00 en mi lista de movimientos


  Scenario: Extraer de una cuenta con dos acuerdos que no tiene mas saldo
    Given una cuenta tiene un saldo de -8500.00
    And un acuerdo en descubierto por 2000.00 con interes de 2.5 %
    And un acuerdo en descubierto por 10000.00 con interes de 2.5 %
    When Intengo extraer 2500.00
    Then El saldo de mi cuenta es de -8500.00
