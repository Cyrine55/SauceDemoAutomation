@SauceLabRequestDemoBook
Feature: Request Demo for Sauce Lab
  En tant que utilisateur je veux faire une registration pour une demo

  @RequestDemo
  Scenario: RegisterRequestDemo
    Given utilisateur ouvre l application
    When saisir username valide
    And saisir mdp valide
    And cliquer sur le bouton Login
    And cliquer sur le menu à gauche
    And cliquer sur 'About'
    Then verifier la redirection à SauceLab
    When cliquer sur le bouton RequestDemo 
    And remplir les champs du BookDemo depuis le fichier Excel
    And Sélectionner interet
    And accepter la régle
    And Cliquer sur le bouton Let's Talk
