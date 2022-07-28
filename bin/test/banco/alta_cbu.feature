Feature: Alta de cbu

  Scenario: Agregegar un cbu valido
    Given la cuenta "0000000001" tiene un saldo de 2000.00
    And la lista de destinatarios esta vacia
    When agrego el cbu "072076268800003566815" a la lista de destinatarios
    Then el cbu "072076268800003566815" queda guardado en la lista de destinatarios
