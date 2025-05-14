package e2e.test.saucedemo.stepdefinitions;

import org.junit.Assert;

import e2e.test.saucedemo.page_objects.CheckoutComplete;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FinalCheckoutStepDefinition {
    CheckoutComplete checkoutComplete;
    
	public FinalCheckoutStepDefinition() {
		checkoutComplete = new 	CheckoutComplete();
	}
	
	@When("cliquer sur le bouton {string}")
	public void cliquerSurLeBouton(String string) {
		checkoutComplete.clickOnFinishBtn();
	}
	@Then("verifier le message {string} est affiche")
	public void verifierLeMessageEstAffiche(String exppectedFinalMsg) {
		String actualSuccessMsg=  checkoutComplete.getFinalSuccessMsg();
		Assert.assertEquals(actualSuccessMsg, exppectedFinalMsg);   
	}



	
	
}
