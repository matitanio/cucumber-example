Feature: Alta un CBU por número

#El cliente con numero de cuenta 00001 agrega el cbu 0720217188000036504936
# y el apodo Micaela Stuckert estos datos pertenecen a Micaela Stuart con cuenta en el
# banco Galicia entonces el cliente lo agrega la lista a mi lista de cbus
Scenario: El cliente agrega un CBU válido
  Given El cliente con número de cuenta "000001"
  When agrega el CBU 0720217188000036504936
  And el apodo "Micaela Stuckert"
  And el CBU pertence a la cuenta del Banco Galicia de Micaela Stuckert
  Then El usuario agrega el CBU a su lista de CBU


#El cliente con Nro de cuenta 00001 al agregar el cbu 000101010101010 y el
# apodo Micaela Stuckert entonces el cbu no se agrega a la lista  y obtiene el mensaje" El nro de cbu es invalido,
# debe tener 22 digitos"
  Scenario: El cliente intenta agregar un CBU que no tiene 22 dígitos
    Given El cliente con número de cuenta "000001"
    When  agrega el CBU 000101010101010
    And   el apodo "Micaela Stuckert"
    Then obtengo el mensaje "El CBU no tiene 22 dígitos"

  #El cliente con numero de cuenta 00001 agrega el cbu 0720217188000036504936
  # y el apodo Micaela Stuckert estos datos pertenecen
  # a Luke Skywalker con cuenta en el "Banco de Nabu" entonces el cliente no agrega la lista a mi lista de cbus
  Scenario: El cliente intenta agregar un CBU válido pero que no corresponde a la persona que quería agregar
    Given El cliente con número de cuenta "000001"
    When agrega el CBU 0720217188000036504936
    And el apodo "Micaela Stuckert"
    And el CBU pertence a la cuenta del Banco Banco de Nabu de Luke Skaywalker
    Then El CBU no se agrega a la lista de cbu

  #El cliente con nro de cuenta 00001 agrega  el CBU  0720217188000036504936
  # y no no agrega un apododo entonces no se agrega el cbu a la lista y obtengo el mensaje "es necesario agregar un apodo"
  Scenario: El cliente agrega un CBU válido
    Given El cliente con número de cuenta "000001"
    When agrega el CBU 0720217188000036504936
    Then Obtengo el mensaje "es necesario agregar un apodo"

  #El cliente con numero de cuenta 00001 agrega el cbu 0720217188000036504936 con el apodo Micaela Stuckert
  # pero nos devuelve un mensaje de error de CBU inexistente
  Scenario: El cliente intenta agregar un CBU que no existe
    Given El cliente con número de cuenta "000001"
    When agrega el CBU 1111111111111111111111
    Then Obtengo el mensaje "CBU inexistente"