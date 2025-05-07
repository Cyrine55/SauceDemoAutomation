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
		double Total = chechkoutOverviewPage.getDisplayedPrice();
		double itemTotal=chechkoutOverviewPage.itemTotalWithTaxe();
		System.out.println("Total : " + Total + " / itemTotal : " + itemTotal);
		//Assert.assertEquals(expTotal, actualectedTotal);
		//Assert.assertEquals("ne sont pas egale",expTotal,actualectedTotal);
		Assert.assertEquals(Total, itemTotal, 0.01); // 0.01 = tolérance
	}



	
	
	
	
	
	
}
