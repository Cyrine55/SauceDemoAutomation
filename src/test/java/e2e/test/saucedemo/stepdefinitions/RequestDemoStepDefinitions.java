package e2e.test.saucedemo.stepdefinitions;

import java.util.List;
import java.util.Map;

import e2e.test.saucedemo.page_objects.RequestDemo;
import e2e.test.saucedemo.utils.ConfigFileReader;
import e2e.test.saucedemo.utils.ExcelReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class RequestDemoStepDefinitions {
	RequestDemo requestDemo;
	ConfigFileReader configFileReader ;
	String sheetName = "RequestDemo";
	
public RequestDemoStepDefinitions() {
	requestDemo = new RequestDemo();
	configFileReader= new ConfigFileReader();
}


@When("cliquer sur {string}")
public void cliquerSur(String string) {
	requestDemo.clickAboutBtn();
}
@Then("verifier la redirection à SauceLab")
public void verifierLaRedirectionÀSauceLab() {
 String actualUrl=  requestDemo.getCurrentUrl() ;
 String exceptedUrl="https://saucelabs.com/";
 Assert.assertEquals(actualUrl, exceptedUrl);

}
@When("cliquer sur le bouton RequestDemo")
public void cliquerSurLeBoutonRequestDemo() {
	requestDemo.clickrequestDemoBtn();
}
@When("remplir les champs du BookDemo depuis le fichier Excel")
public void remplirLesChampsDuBookDemoDepuisLeFichierExcel() {
	String sheetName = "RequestDemo";
	 List<Map<String, String>> BookDemo = ExcelReader.readExcel(configFileReader.getExcelFilePath(), sheetName);
	  for (Map<String, String> demo : BookDemo) {
          requestDemo.remplirEmail(demo.get("Email"));
          requestDemo.remplirFirstName(demo.get("FirstName"));
          requestDemo.remplirLastName(demo.get("LastName"));
          requestDemo.remplirCompany(demo.get("Company"));
          requestDemo.remplirComment(demo.get("Comment"));
          
      }
  }

@When("Sélectionner interet")
public void sélectionnerInteret() {

}
@When("accepter la régle")
public void accepterLaRégle() {

}
@When("Cliquer sur le bouton Let's Talk")
public void cliquerSurLeBoutonLetSTalk() {
   
}












}
