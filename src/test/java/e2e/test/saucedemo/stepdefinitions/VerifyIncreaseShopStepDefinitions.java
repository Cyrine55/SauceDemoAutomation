package e2e.test.saucedemo.stepdefinitions;

import org.junit.Assert;

import e2e.test.saucedemo.page_objects.AddProductInCart;
import e2e.test.saucedemo.page_objects.HomePage;
import io.cucumber.java.en.Then;

public class VerifyIncreaseShopStepDefinitions {
	HomePage homePage;
	AddProductInCart addProductInCart;
	AddProductInCartStepDefinitions addProductInCartStepDefinitions;
public VerifyIncreaseShopStepDefinitions() {
	homePage=new HomePage();
	addProductInCart= new AddProductInCart();
	addProductInCartStepDefinitions = new AddProductInCartStepDefinitions();
}

@Then("verifier incrementation nombre affiche dans icone panier")
public void verifierIncrementationNombreAfficheDansIconePanier() {
   String actualIconNbr=homePage.verifyIncreaseShopIcon();
   Assert.assertEquals(actualIconNbr, "1");
}


@Then("le badge du panier affiche le bon nombre de produits")
public void leBadgeDuPanierAfficheLeBonNombreDeProduits() {
	 String actualIconNbr=homePage.verifyIncreaseShopIcon();
	 Assert.assertEquals(String.valueOf(addProductInCartStepDefinitions.nbProduitsAjoutes), actualIconNbr);
	 
}





}
