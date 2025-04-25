package e2e.test.saucedemo.stepdefinitions;

import java.util.Map;

import e2e.test.saucedemo.page_objects.CartPage;
import e2e.test.saucedemo.page_objects.CheckoutInformation;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CheckoutInformationStepDefinition {
	CartPage cartPage;
	CheckoutInformation checkoutInformation;
	public CheckoutInformationStepDefinition() {
		cartPage = new CartPage();
		checkoutInformation = new CheckoutInformation();
	}
	

	@When("Cliquer sur le Boutoncheckout {string}")
	public void cliquerSurLeBoutoncheckout(String string) {
		cartPage.clickCheckoutBtn();   
	}
	
	@When("entrer les informations checkout")
	public void entrerLesInformationsCheckout(DataTable informationsTable) {
		Map<String, String> dataMap = informationsTable.asMap(String.class, String.class);
		checkoutInformation.addChekoutFirstname(dataMap.get("firstname"));
		checkoutInformation.addChekoutLastname(dataMap.get("lastname"));
		checkoutInformation.addChekoutPostalCode(dataMap.get("postalcode"));
	}



	
	@When("cliquer sur le boutonContinue {string}")
	public void cliquerSurLeBoutonContinue(String string) {
		checkoutInformation.cliquerSurContinue();   
	}
	
	@Then("verify redirection to chekout overview page with url {string}")
	public void verifyRedirectionToChekoutOverviewPage(String expectedUrl) {
		String actualUrl=checkoutInformation.getcheckoutStep2Url();
		//String exceptedUrl="https://www.saucedemo.com/checkout-step-two.html";
		Assert.assertEquals(actualUrl, expectedUrl);
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
