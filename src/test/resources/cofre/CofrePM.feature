# language: en
# Source: http://github.com/aslakhellesoy/cucumber/blob/master/examples/i18n/en/features/addition.feature
# Updated: Tue May 25 15:51:43 +0200 2010
Feature: CofrePM
  Como um usuario
  eu quero digitar a senha
  e saber se ela abre ou não o cofre
  ou poder travar o cofre quando ele está destravado

  Scenario: Testar se senha abre cofre
    Given que temos uma instancia de CofrePM com SensorPorta e uma Memoria
    And eu digitei a senha invalida
    When eu apertei ok
    Then a mensagem do display deve ser "senha errada. Tente novamente"

  Scenario: Testar travar cofre colocando senha com porta aberta
    Given que temos uma instancia de CofrePM com SensorPorta e uma Memoria
    And eu digitei uma senha com a porta aberta
    When eu apertei ok
    Then a mensagem do display deve ser "Feche a porta antes de digitar a senha"
