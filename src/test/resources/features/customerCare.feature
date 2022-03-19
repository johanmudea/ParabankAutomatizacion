Feature:
  yo como cliente
  deseo contactar equipo de soporte
  para solicitar informacion.

  Scenario:
    Given ingreso mi informacion de contacto
    When estoy en el formulario de contacto
    Then debe enviarme mensaje de comfirmacion

    Scenario:
      Given ingreso no diligencia el email
      When estoy en el formulario de contacto
      Then debe enviarme mensaje de "Email is required."

