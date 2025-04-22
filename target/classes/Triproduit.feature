
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
 
 
  @TriDeCroissant
  Scenario: Tri des produits croissant
    Given utilisateur ouvre l application
    When saisir username valide
    And saisir mdp valide
    And cliquer sur le bouton Login
    And cliquer sur le choix 'Price (high to low)' du dropdown
    Then verifier que les prix affiches en mode decroissant
     
   @TriNameAtoZ 
  Scenario: Tri des Produits en ordre alphabétique du Z à A 
    Given utilisateur ouvre l application
    When saisir username valide
    And saisir mdp valide
    And cliquer sur le bouton Login
    And cliquer sur le choix 'Name (A to Z)' du dropdown
    Then verifier que les produits affichés en ordre alphabétique de A à Z
    
    
  @TriNameZtoA
  Scenario: Tri des Produits en ordre alphabétique du Z à A 
    Given utilisateur ouvre l application
    When saisir username valide
    And saisir mdp valide
    And cliquer sur le bouton Login
    And cliquer sur le choix 'Name (Z to A)' du dropdown
    Then verifier que les produits affichés en ordre alphabétique de Z à A