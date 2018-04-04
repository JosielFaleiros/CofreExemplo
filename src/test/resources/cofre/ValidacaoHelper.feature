# language: en
# Source: http://github.com/aslakhellesoy/cucumber/blob/master/examples/i18n/en/features/addition.feature
# Updated: Tue May 25 15:51:43 +0200 2010
Feature: ValidacaoHelper
  Como um usuario
  eu quero saber se uma senha entrada eh valida
  para evitar senhas invalidas

  Scenario Outline: Testar se senha valida
    When que eu entrei a senha <senha>
    Then a senha deve ser valida

    Examples: 
      | senha    |
      | "123999" |

  Scenario Outline: Testar se senha invalida
    When que eu entrei a senha <senha>
    Then a senha deve ser invalida

    Examples: 
      | senha    |
      | "123"    |
      | "123"    |
      | "12345"  |
      | "12345a" |
