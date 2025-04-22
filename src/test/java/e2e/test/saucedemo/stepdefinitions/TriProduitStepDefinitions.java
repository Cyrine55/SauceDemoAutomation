package e2e.test.saucedemo.stepdefinitions;



import org.junit.Assert;

import e2e.test.saucedemo.page_objects.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TriProduitStepDefinitions {
	HomePage homePage;
	
public TriProduitStepDefinitions() {
	homePage = new HomePage();

}


@When("cliquer sur le choix {string} du dropdown")
public void cliquerSurLeChoixDuDropdown(String string) {
   homePage.cliqueChoixDropDown(string);
     
}

@Then("verifier le tri des produits est croissant")
public void verifierLeTriDesProduitsEstCroissant() {
	Assert.assertTrue("Les prix ne sont pas triés du plus bas au plus haut", 
           homePage.isPriceSortedAscending()); 
}


@Then("verifier que les prix affiches en mode decroissant")
public void verifierQueLesPrixAffichesEnModeDecroissant() {
	Assert.assertTrue("Les prix ne sont pas triés du plus haut au plus bas", 
	           homePage.isPriceSortedDescending()); 
}

@Then("verifier que les produits affichés en ordre alphabétique de Z à A")
public void verifierQueLesProduitsAffichésEnOrdreAlphabétiqueDeZÀA() {
	Assert.assertTrue("Les produits ne sont pas triés de Z à A", homePage.sortedProductZtoA());
}

@Then("verifier que les produits affichés en ordre alphabétique de A à Z")
public void verifierQueLesProduitsAffichésEnOrdreAlphabétiqueDeAÀZ() {
   Assert.assertTrue("les produits ne sont pas triés en ordre alphabétique du A to Z",homePage.sortedProductAToA());
}








}
