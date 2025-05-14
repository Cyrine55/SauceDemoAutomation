
@FinalCheckout
Feature: Verify final checkout
  En tant que utilisateur je veux verifier la partie final du checkout

  @FinalCheckout
  Scenario: Title of your scenarioVerify final checkout
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
    And cliquer sur le bouton 'Finish'
    Then verifier le message 'Thank you for your order!' est affiche 
    
 
