@CheckoutOverview
Feature: Verification Details in Checkout Overview Details

@VerifyPricesInCheckoutOverview
Scenario: Verify display products prices in chekcout overview page
 Given utilisateur ouvre l application
    When saisir username valide
    And saisir mdp valide
    And cliquer sur le bouton Login
    When cliquer sur le bouton Add to cart pour le produit 'Sauce Labs Onesie'
    When cliquer sur le bouton panier
    And Cliquer sur le Boutoncheckout 'Checkout'
    And entrer les informations checkout
    | firstname    | Cyrine           |
      | lastname   | yefrni |
      | postalcode | test QA          |
      
    And cliquer sur le boutonContinue 'Continue' 
    Then verify total price displayed with exact value
    
    
    
    @VerifyCheckoutforProducts
 Scenario Outline: VerifyCheckoutforProducts
    Given utilisateur ouvre l application
    When saisir username valide
    And saisir mdp valide
    And cliquer sur le bouton Login
    When ajouter des produits <nomProduits>
    When cliquer sur le bouton panier
    And Cliquer sur le Boutoncheckout 'Checkout'
    And entrer les informations checkout
    | firstname    | Cyrine           |
      | lastname   | yefrni |
      | postalcode | test QA          |
      
    And cliquer sur le boutonContinue 'Continue' 
    Then verify total price displayed with exact value
    Examples:
 | nomProduits        |
  | "Sauce Labs Onesie, Sauce Labs Backpack" |