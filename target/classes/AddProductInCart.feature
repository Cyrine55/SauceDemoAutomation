@AddProductInCart
Feature: En tant que utilisateur je veux ajouter des produits dans la carte

@AddProductInCartWithIndex
Scenario: Add product in cart with index 
    Given utilisateur ouvre l application
    When saisir username valide
    And saisir mdp valide
    And cliquer sur le bouton Login
    When cliquer sur le bouton 'Add to cart' pour un produit
    When cliquer sur le bouton panier
    Then verifier le produit est ajouter dans la carte
    
    
 @AddProductInCartWithProductName
 Scenario: Add product in cart with productName 
    Given utilisateur ouvre l application
    When saisir username valide
    And saisir mdp valide
    And cliquer sur le bouton Login
    When cliquer sur le bouton Add to cart pour le produit 'Sauce Labs Onesie'
    When cliquer sur le bouton panier
    Then verifier le produit 'Sauce Labs Onesie' est ajouter dans la carte
 
 @AddManyProducts
 Scenario Outline: Add many products in cart  
    Given utilisateur ouvre l application
    When saisir username valide
    And saisir mdp valide
    And cliquer sur le bouton Login
    When ajouter des produits <nomProduits>
    When cliquer sur le bouton panier
    Then verifier les produits correspondants affiches 
    Examples:
  | nomProduits  |
  | "Sauce Labs Onesie"|
  | "Sauce Labs Backpack"|