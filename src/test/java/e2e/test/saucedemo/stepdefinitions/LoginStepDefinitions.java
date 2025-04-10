package e2e.test.saucedemo.stepdefinitions;





import org.junit.Assert;

import e2e.test.saucedemo.page_objects.LoginPage;
import e2e.test.saucedemo.utils.ConfigFileReader;
import e2e.test.saucedemo.utils.Setup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitions {
	
	public LoginPage loginPage ;
	public ConfigFileReader configFileReader;
	
	
	public LoginStepDefinitions() {
		loginPage = new LoginPage();
		configFileReader = new ConfigFileReader();
	}
	
	
	
	
	
	@Given("utilisateur ouvre l application")
	public void utilisateurOuvreLApplication() {
	Setup.getDriver().get(configFileReader.getProperties("url"));
	}
	
	@When("saisir username valide")
	public void saisirUsernameValide() {
		String username = configFileReader.getProperties("username");
		loginPage.saisirUsername(username);
	}
	
	@When("saisir mdp valide")
	public void saisirMdpValide() {
		String password = configFileReader.getProperties("password");    
		loginPage.saisirPassword(password);	
	}
	
	@When("cliquer sur le bouton Login")
	public void cliquerSurLeBoutonLogin() {
	loginPage.cliquerLoginBtn();	
	}
	
	@Then("Redirection au menu Swag Labs")
	public void redirectionAuMenuSwagLabs() {
	 String actualUrl=loginPage.getHomeURL () ;
	 String exceptedUrl="https://www.saucedemo.com/inventory.html";
	 Assert.assertEquals(actualUrl, exceptedUrl);
	}
 
	@Then("verifier message erreur {string} affiche")
	public void verifierMessageErreurAffiche(String uernameEmptyMsg) {
	  String actualErrorusernameMsg=loginPage.getErrorEmptyUsername();
	  String expectedErrorusernameMsg="Epic sadface: Username is required";
	  Assert.assertEquals(actualErrorusernameMsg, expectedErrorusernameMsg);
	}



	



}
