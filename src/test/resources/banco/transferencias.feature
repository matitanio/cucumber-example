Feature: Transferir entre cuentas propias

  Scenario: Transferir desde una cuenta con saldo otra cuenta con saldo
    Given la cuenta "0000000001" con saldo de 20000.00
    And la cuenta "0000000002" con saldo de 30000.00
    When transfiero 8000.00 de la cuenta "0000000001" a la cuenta "0000000002"
    Then El saldo de la cuenta "0000000001" es 12000.00
    And Tengo el movimiento de transferencia por -8000.00 en la lista de movimientos de la cuenta "0000000001"
    And El saldo de la cuenta "0000000002" es 38000.00
    And Tengo el movimiento de transferencia por 8000.00 en la lista de movimientos de la cuenta "0000000002"