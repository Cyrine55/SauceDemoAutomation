package e2e.test.saucedemo.page_objects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import e2e.test.saucedemo.utils.BasePage;
import e2e.test.saucedemo.utils.SeleniumUtils;
import e2e.test.saucedemo.utils.Setup;
import e2e.test.saucedemo.utils.Wait;

public class LoginPage extends BasePage {

	@FindBy(how = How.ID, using = "user-name")
	private static WebElement usernameField;
	@FindBy(how = How.ID, using = "password")
	private static WebElement passwordField;
	@FindBy(how = How.ID, using = "login-button")
	private static WebElement loginBtn;
	@FindBy(how = How.XPATH, using = "//div[@class='error-message-container error']/h3[@data-test='error']")
	private static WebElement msgErrorUsername;

	SeleniumUtils seleniumUtils;
	Wait wait;

	public LoginPage() {
		super(Setup.getDriver());
		seleniumUtils = new SeleniumUtils();
		wait = new Wait(driver);

	}

	public void saisirUsername(String username) {
		seleniumUtils.clearField(usernameField);
		seleniumUtils.writeText(usernameField, username);

	}
	
	public void saisirPassword( String password) {
		seleniumUtils.clearField(passwordField);
		seleniumUtils.writeText(passwordField, password);
	}
	public void cliquerLoginBtn()  {
		By loginBtnLocator = By.xpath("//input[@type='password']");
		seleniumUtils.waitForElementToBeClickable(loginBtnLocator);
		seleniumUtils.click(loginBtn);
		
	}

	public String getHomeURL() {
	String url= seleniumUtils.getCurrentUrl();
	System.out.println(url);
	 return url;
	
	}
	
	public String getErrorEmptyUsername() {
		wait.waitUntilElementVisible(driver, msgErrorUsername);
		String errorUsernameMsg= msgErrorUsername.getText();
		return errorUsernameMsg ;
	}
}
