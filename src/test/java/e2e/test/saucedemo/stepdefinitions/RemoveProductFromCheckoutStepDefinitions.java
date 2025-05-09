package e2e.test.saucedemo.stepdefinitions;

import org.junit.Assert;

import e2e.test.saucedemo.page_objects.CartPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RemoveProductFromCheckoutStepDefinitions {
	CartPage cartPage;
	private String produitSupprime;
	
public RemoveProductFromCheckoutStepDefinitions() {
	cartPage= new CartPage();
}

/** Dans la fonction de suppression , on va enregistrer le nom du produit supprimé, ce qui on va l'utiliser dans l'étape de vérification 
 */
@When("cliquer sur le bouton Remove pour le produit {string}")
public void cliquerSurLeBoutonRemovePourLeProduit(String produit) {
  cartPage.removeProduit(produit);  
  produitSupprime = produit;
}
@Then("verifier le produit n pas existe dans la liste")
public void verifierLeProduitNPasExisteDansLaListe() {
	
    Assert.assertFalse(cartPage.getproductRemoved(produitSupprime));
}




}
