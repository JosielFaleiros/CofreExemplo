# language: en
# Source: http://github.com/aslakhellesoy/cucumber/blob/master/examples/i18n/en/features/addition.feature
# Updated: Tue May 25 15:51:43 +0200 2010
Feature: CofrePM
  Como um usuario
  eu quero digitar a senha
  e saber se ela abre ou não o cofre
  ou poder travar o cofre quando ele está destravado

  Scenario: Testar se senha invalida abre cofre
    Given que temos uma instancia de CofrePM com SensorPorta e uma Memoria
    And eu digitei a senha invalida
    When eu apertei ok
    Then a mensagem do display deve ser "senha errada. Tente novamente"

  Scenario: Testar se senha menos de seis abre cofre
    Given que temos uma instancia de CofrePM com SensorPorta e uma Memoria
    And eu digitei a senha com menos de seis
    When eu apertei ok
    Then a mensagem do display deve ser "senha errada. Tente novamente"

  Scenario: Testar se senha correta abre cofre
    Given que temos uma instancia de CofrePM com SensorPorta e uma Memoria
    And eu digitei a senha correta
    When eu apertei ok
    Then a mensagem do display deve ser "senha correta. Cofre aberto"

  Scenario: Testar travar cofre colocando senha com porta aberta
    Given que temos uma instancia de CofrePM com SensorPorta e uma Memoria
    And eu digitei uma senha com a porta aberta
    When eu apertei ok
    Then a mensagem do display deve ser "Feche a porta antes de digitar a senha"

  Scenario: Testar travar cofre colocando senha com um numero porta fechada
    Given que temos uma instancia de CofrePM com SensorPorta e uma Memoria
    And eu digitei uma senha com um numero com porta fechada
    Then a mensagem do display deve ser "0"

  Scenario: Testar gravar senha valida porta fechada destravada
    Given que temos uma instancia de CofrePM com SensorPorta e uma Memoria
    And eu digitei uma senha valida com porta fechada
    When eu apertei ok
    Then a mensagem do display deve ser "Senha salva. Cofre trancado"

  Scenario: Testar gravar senha menos de seis porta fechada destravada
    Given que temos uma instancia de CofrePM com SensorPorta e uma Memoria
    And eu digitei uma senha com menos de seis
    When eu apertei ok
    Then a mensagem do display deve ser "senha precisa de 6 digitos. Tente novamente"


  Scenario: Testar digitar numeros porta fechada depois abrir editar
    Given que temos uma instancia de CofrePM com SensorPorta e uma Memoria
    And eu digitei uma senha com a porta fechada
    When eu abri a porta
    Then a mensagem do display deve ser "Feche a porta antes de digitar a senha"
