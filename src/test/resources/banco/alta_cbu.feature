Feature: Alta un CBU por número

Scenario: El cliente agrega un CBU válido
  Given El cliente con número de cuenta "000001"
  When cuando agrega el CBU 0720217188000036504936
  And el apodo "Micaela Stuckert"
  And el CBU pertence a la cuenta del Banco Galicia de Micaela Stuckert
  Then El usuario agrega el CBU a su lista de CBU


