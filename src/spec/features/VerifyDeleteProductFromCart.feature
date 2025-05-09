
@tag
Feature: Delete product from cart 
  En tant que utilisateur je veux vérifier la suppression produit depuis la carte

  @DeleteProductFromCart
  Scenario Outline: Add many products incart  
    Given utilisateur ouvre l application
    When saisir username valide
    And saisir mdp valide
    And cliquer sur le bouton Login
    When ajouter des produits <nomProduits>
    When cliquer sur le bouton panier
     And cliquer sur le bouton Remove pour le produit 'Sauce Labs Backpack' 
    Then verifier le produit n pas existe dans la liste 
    Examples: 
 | nomProduits        |
  | "Sauce Labs Onesie, Sauce Labs Backpack" |


