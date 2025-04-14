
@Triproduit
Feature: Trier la liste des produits
  En tant que utilisateur je veux vérifier le tri de la liste des produits

  @TriCroissant
  Scenario: Tri des produits croissant
    Given utilisateur ouvre l application
    When saisir username valide
    And saisir mdp valide
    And cliquer sur le bouton Login
    And cliquer sur le choix 'Price (low to high)' du dropdown
    Then verifier le tri des produits est croissant
 