package e2e.test.saucedemo.stepdefinitions;

import e2e.test.saucedemo.page_objects.CheckoutOverviewPage;
import io.cucumber.java.en.Then;



import org.junit.Assert;

public class CheckoutOverviewStepDefinition {

	CheckoutOverviewPage chechkoutOverviewPage;

	public CheckoutOverviewStepDefinition() {
		chechkoutOverviewPage = new CheckoutOverviewPage();
	}
	
	

	@Then("verify total price displayed with exact value")
	public void verifyTotalPriceDisplayedWithExactValue() {
		double expTotal = chechkoutOverviewPage.getDisplayedPrice();
		double actualectedTotal=chechkoutOverviewPage.getPrices();
		System.out.println("Calculé : " + expTotal + " / Affiché : " + actualectedTotal);
		//Assert.assertEquals(expTotal, actualectedTotal);
		//Assert.assertEquals("ne sont pas egale",expTotal,actualectedTotal);
		Assert.assertEquals(expTotal, actualectedTotal, 0.01); // 0.01 = tolérance
	}



	
	
	
	
	
	
}
