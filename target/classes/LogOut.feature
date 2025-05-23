
@Logout
Feature: Deconnexion
  En tant que utilisateur ve veux me deconnecter

  @Logout
  Scenario: Deconnecter de l application
    Given utilisateur ouvre l application
    When saisir username valide
    And saisir mdp valide
    And cliquer sur le bouton Login
    And cliquer sur le menu à gauche
    And cliquer sur bouton 'Logout'
    Then verifier la redirection de l ecran login 
    

  