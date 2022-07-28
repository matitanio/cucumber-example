Feature: Transferir entre cuentas propias por numero de cuenta

  Scenario: Transferir desde una cuenta con saldo otra cuenta con saldo
    Given la cuenta "0000000001" con saldo de 20000.00
    And la cuenta "0000000002" con saldo de 30000.00
    When transfiero 8000.00 de la cuenta "0000000001" a la cuenta "0000000002"
    Then El saldo de la cuenta "0000000001" es 12000.00
    And Tengo el movimiento de transferencia por -8000.00 en la lista de movimientos de la cuenta "0000000001"
    And El saldo de la cuenta "0000000002" es 38000.00
    And Tengo el movimiento de transferencia por 8000.00 en la lista de movimientos de la cuenta "0000000002"

  Scenario: Transferir desde una cuenta que queda en descubierto a otra cuenta con saldo
    Given la cuenta "0000000001" con saldo de 20000.00
    And un acuerdo en descubierto por 5000.00 con interes de 2.5 %
    And la cuenta "0000000002" con saldo de 30000.00
    When transfiero 22000.00 de la cuenta "0000000001" a la cuenta "0000000002"
    Then El saldo de la cuenta "0000000001" es -2000.00
    And Tengo el movimiento de transferencia por -22000.00 en la lista de movimientos de la cuenta "0000000001"
    And El saldo de la cuenta "0000000002" es 52000.00
    And Tengo el movimiento de transferencia por 22000.00 en la lista de movimientos de la cuenta "0000000002"

  Scenario: Transferir desde una cuenta que no tiene saldo suficiento y el acuerdo no alcanza para cubrir el total de la transferencia
    Given la cuenta "0000000001" con saldo de 2000.00
    And un acuerdo en descubierto por 500.00 con interes de 2.5 %
    And la cuenta "0000000002" con saldo de 3000.00
    When intento transfereir 2600.00 de la cuenta "0000000001" a la cuenta "0000000002"
    Then obtengo el mensaje "Saldo Insuficiente"
    And El saldo de la cuenta "0000000001" es 2000.00
    And El saldo de la cuenta "0000000002" es 3000.00

  Scenario: Transferir desde una cuenta que no tiene saldo suficiento
    Given la cuenta "0000000001" con saldo de 2000.00
    And la cuenta "0000000002" con saldo de 3000.00
    When intento transfereir 2600.00 de la cuenta "0000000001" a la cuenta "0000000002"
    Then obtengo el mensaje "Saldo Insuficiente"
    And El saldo de la cuenta "0000000001" es 2000.00
    And El saldo de la cuenta "0000000002" es 3000.00