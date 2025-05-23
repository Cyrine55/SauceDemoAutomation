package e2e.test.saucedemo.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import e2e.test.saucedemo.utils.BasePage;
import e2e.test.saucedemo.utils.SeleniumUtils;
import e2e.test.saucedemo.utils.Setup;

public class RequestDemo extends BasePage{

	@FindBy(how=How.ID,using="about_sidebar_link")
	private static WebElement aboutBtn;
	@FindBy(how=How.XPATH,using="//button[normalize-space()='Request a demo']")
	private static WebElement requestDemoBtn;
	@FindBy(how=How.ID,using="Email")
	private static WebElement emailField;
	@FindBy(how=How.XPATH,using="//input[@id='FirstName']")
	private static WebElement firstNameField;
	@FindBy(how=How.XPATH,using="//input[@id='LastName']")
	private static WebElement lastNameField;
	@FindBy(how=How.ID,using="Company")
	private static WebElement companyField;
	@FindBy(how=How.ID,using="Phone")
	private static WebElement phoneField;
	@FindBy(how=How.ID,using="Sales_Contact_Comments__c")
	private static WebElement commentField;
	
	

	
	
	SeleniumUtils seleniumUtils;
	public RequestDemo() {
		super(Setup.getDriver());
		seleniumUtils = new SeleniumUtils();
	}
	
	public void clickAboutBtn() {
		seleniumUtils.clickOnElementUsingJs(aboutBtn);
	}
	public String getCurrentUrl() {
		return seleniumUtils.getCurrentUrl();
	}
	public void clickrequestDemoBtn() {
		seleniumUtils.click(requestDemoBtn);	
	}
	
	public void remplirEmail(String email) {
		seleniumUtils.waitForElementToBeClickable(emailField);
		seleniumUtils.writeText(emailField,email);
	}
	public void remplirFirstName(String firstname) {
		seleniumUtils.waitForElementToBeClickable(firstNameField);
		seleniumUtils.writeText(firstNameField,firstname);
	}
	public void remplirLastName(String lastname) {
		seleniumUtils.waitForElementToBeClickable(lastNameField);
		seleniumUtils.writeText(lastNameField,lastname);
	}
	public void remplirCompany(String company) {
		seleniumUtils.waitForElementToBeClickable(companyField);
		seleniumUtils.writeText(companyField,company);
	}

	public void remplirComment(String comment) {
		seleniumUtils.waitForElementToBeClickable(commentField);
		seleniumUtils.writeText(commentField,comment);
	}
	
	
}
