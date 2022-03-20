Feature:
  Yo como administrador
  quiero acceder a la pagina register
  para validar el direccionamiento

  Scenario:
    Given el administrador esta en el sitio web
    When Click en link de register
    Then Se muestra la pagina de registro

  Scenario:
    Given Usuario esta en la pagina de registro
    When dilgencia la informacion
    Then Se muestra confirmacion de registro


