package e2e.test.saucedemo.stepdefinitions;

import org.junit.Assert;

import e2e.test.saucedemo.page_objects.LogoutPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogOutStepDefinitions {
	
	LogoutPage logOutPage;
public LogOutStepDefinitions() {
	logOutPage = new LogoutPage();
}


@When("cliquer sur le menu à gauche")
public void cliquerSurLeMenuÀGauche() {
	logOutPage.cliqueSurMenu();  
}
@When("cliquer sur bouton {string}")
public void cliquerSurBouton(String string) {
	logOutPage.clickonLogOutBtn();
}
@Then("verifier la redirection de l ecran login")
public void verifierLaRedirectionDeLEcranLogin() {
  String currentUrl=logOutPage.getCurrentUrl();
  String extectedUrl="https://www.saucedemo.com/";
  Assert.assertEquals(currentUrl, extectedUrl);
}



}
