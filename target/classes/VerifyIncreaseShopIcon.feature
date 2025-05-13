
@IncreaseShopIcon
Feature: Verify increase shop icon 
En tant que utilisateur je veux verifier le nombre affiché dans l icone


@IncreaseIconWithOnePdt
 Scenario: Increase shop icon 
    Given utilisateur ouvre l application
    When saisir username valide
    And saisir mdp valide
    And cliquer sur le bouton Login
    When cliquer sur le bouton Add to cart pour le produit 'Sauce Labs Onesie'
    Then verifier incrementation nombre affiche dans icone panier
    
    
 @IncreaseIconManyProducts
 Scenario Outline: Increase Icon for adding multiples products
 Given utilisateur ouvre l application
    When saisir username valide
    And saisir mdp valide
    And cliquer sur le bouton Login
    When ajouter des produits <nomProduits>
      Then le badge du panier affiche le bon nombre de produits
       Examples:
 | nomProduits        |
  | "Sauce Labs Onesie, Sauce Labs Backpack" |


 