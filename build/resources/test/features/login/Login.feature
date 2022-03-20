Feature:
  Yo como administrador
  deseo probar el boton de login
  para validar su funcionalidad

  Scenario:
    Given estoy en el sitio web
    When click en login sin diligenciar datos de usuario
    Then envia mensaje de error

    Scenario:
      Given el usuario esta en  el sitio web
      When diligencia sus credenciales correctamente
      Then se muestra log out