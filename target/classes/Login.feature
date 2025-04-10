
@Login
Feature: Authentification
  j

  @ValidLogin
  Scenario: Verification authentification
    Given utilisateur ouvre l application
    When saisir username valide
    And saisir mdp valide
    And cliquer sur le bouton Login
    Then Redirection au menu Swag Labs
    
    @InValidLoginWithEmptyUsername
    Scenario: Verification login sans saisir username
    Given utilisateur ouvre l application
    And saisir mdp valide
    And cliquer sur le bouton Login
    Then verifier message erreur 'Epic sadface: Username is required' affiche 
