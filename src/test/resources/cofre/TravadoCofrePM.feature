# language: en
# Source: http://github.com/aslakhellesoy/cucumber/blob/master/examples/i18n/en/features/addition.feature
# Updated: Tue May 25 15:51:43 +0200 2010
Feature: TravadoCofrePM
  Como um usuario
  eu quero digitar a senha
  e saber se ela abre ou não o cofre

  Scenario: Testar se senha abre cofre
    Given que temos uma instancia de CofrePM com SensorPorta e uma Memoria
    And eu digitei a senha invalida
    When eu apertei ok
    Then a mensagem do display deve ser "senha errada. Tente novamente"
