Feature:
  yo como cliente
  deseo contactar equipo de soporte
  para solicitar informacion.

  Background:
    Given : El cliente esta en el sitio web de contacto


  Scenario: solicitud de contacto exitosa
    When El cliente ingresa sus credenciales.
    Then debe enviarme mensaje de comfirmacion.

  Scenario: solicitud de contacto errada por email
    When El cliente no diligencia el Email
    Then debe mostrar mensaje de error Email is required.

