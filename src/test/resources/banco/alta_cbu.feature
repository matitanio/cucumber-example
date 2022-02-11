Feature: Alta de cbu

  Scenario: Agregegar un cbu valido
    Given la cuenta "0000000001"
    And el cbu es valido y existe
    When agrego el cbu a la lista de destinatarios
    Then el cbu queda guardado en la lista de destinatarios
