
@Login
Feature: Authentification
  je veux tester la partie authentification 

  @ValidLogin
  Scenario: Verification authentification
    Given utilisateur ouvre l application
    When saisir username valide
    And saisir mdp valide
    And cliquer sur le bouton Login
    Then Redirection au menu Swag Labs
    
  
