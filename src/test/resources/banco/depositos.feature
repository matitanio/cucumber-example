Feature: Depositar dinero en una Caja de Ahorro

  Scenario: Una cuenta con Saldo positivo
    Given la cuenta "0000000001" tiene un saldo de 2000.00
    When Deposito 300.00 en la cuenta
    Then El saldo de mi cuenta es de 2300.00
    And Tengo el movimiento por 300.00 en mi lista de movimientos

  Scenario: Una cuenta con Saldo negativo
    Given la cuenta "0000000001" tiene un saldo de -2000.00
    And un acuerdo en descubierto por 2000.00 con interes de 2.5 %
    When Deposito 3000.00 en la cuenta
    Then El saldo de mi cuenta es de 950.00
    And Tengo el movimiento por 3000.0 en mi lista de movimientos
    And Tengo el movimiento por 50.0 de interes por el descubierto

  Scenario: Una cuenta con Saldo negativo y acuerdo sin interes
    Given la cuenta "0000000001" tiene un saldo de -2000.00
    And un acuerdo en descubierto sin interes hasta 2000
    When Deposito 3000.00 en la cuenta
    Then El saldo de mi cuenta es de 1000.00
    And Tengo el movimiento por 3000.0 en mi lista de movimientos
    And No tengo el movimiento de interes

  Scenario: Una cuenta con Saldo negativo y dos acuerdos uno con interes y otro sin interes y no me paso del monto del acuerdo sin interes
    Given la cuenta "0000000001" tiene un saldo de -2000.00
    And un acuerdo en descubierto sin interes hasta 2000
    And un acuerdo en descubierto por 5000.00 con interes de 2.5 %
    When Deposito 3000.00 en la cuenta
    Then El saldo de mi cuenta es de 1000.00
    And Tengo el movimiento por 3000.0 en mi lista de movimientos
    And No tengo el movimiento de interes

  Scenario: Una cuenta con Saldo negativo y dos acuerdos uno con interes y otro sin interes y me paso del monto de acuerdo sin interes
    Given la cuenta "0000000001" tiene un saldo de -2000.00
    And un acuerdo en descubierto sin interes hasta 2000
    And un acuerdo en descubierto por 5000.00 con interes de 2.5 %
    When Deposito 3000.00 en la cuenta
    Then El saldo de mi cuenta es de 1000.00
    And Tengo el movimiento por 3000.0 en mi lista de movimientos
    And No tengo el movimiento de interes