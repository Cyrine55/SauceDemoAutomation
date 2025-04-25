@CheckoutInformation
Feature: En tant que utilisateur je veux vérifier  la partie information 

@CheckoutInformation
Scenario: Verify checkout information
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
    Then verify redirection to chekout overview page with url 'https://www.saucedemo.com/checkout-step-two.html'