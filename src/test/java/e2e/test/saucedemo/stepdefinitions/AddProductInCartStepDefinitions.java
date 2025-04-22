package e2e.test.saucedemo.stepdefinitions;

import org.junit.Assert;

import e2e.test.saucedemo.page_objects.AddProductInCart;
import e2e.test.saucedemo.page_objects.CartPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddProductInCartStepDefinitions {
	AddProductInCart addProductInCart;
	CartPage cartPage;
	int index = 3;
	private String produitsAjoutes;
	public AddProductInCartStepDefinitions() {
		addProductInCart = new AddProductInCart();
		cartPage = new CartPage();
	}

	@When("cliquer sur le bouton {string} pour un produit")
	public void cliquerSurLeBoutonPourUnProduit(String string) {
		addProductInCart.clickOnAddToCart(index);
	}

	@When("cliquer sur le bouton panier")
	public void cliquerSurLeBoutonPanier() {
		addProductInCart.clickOnPanierBtn();
	}

	@Then("verifier le produit est ajouter dans la carte")
	public void verifierLeProduitEstAjouterDansLaCarte() {
		Boolean actualResult = cartPage.productIsDisplayed();
		Assert.assertTrue("produit ajouté n'est pas affiché dans la carte", actualResult);
	}

	@When("cliquer sur le bouton Add to cart pour le produit {string}")
	public void cliquerSurLeBoutonAddToCartPourLeProduit(String productName) {
		addProductInCart.addProductWithName(productName);
	}

	@Then("verifier le produit {string} est ajouter dans la carte")
	public void verifierLeProduitEstAjouterDansLaCarte(String productName) {
		String actualpdtName = cartPage.pdpNameIsDisplayedonCarte();
		Assert.assertEquals(actualpdtName, productName);

	}

	@When("ajouter des produits {string}")
	public void ajouterDesProduits(String produits) {
		 this.produitsAjoutes = produits;
		addProductInCart.addManyProducts(produits);
	}

	@Then("verifier les produits correspondants affiches")
	public void verifierLesProduitsCorrespondantsAffiches() {
		boolean result = cartPage.verifyProductsInCart(produitsAjoutes);
	    Assert.assertTrue("Certains produits attendus ne sont pas présents dans le panier", result);
	}

}
