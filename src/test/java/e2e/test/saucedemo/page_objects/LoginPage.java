package e2e.test.saucedemo.page_objects;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import e2e.test.saucedemo.utils.BasePage;
import e2e.test.saucedemo.utils.SeleniumUtils;
import e2e.test.saucedemo.utils.Setup;

public class LoginPage extends BasePage {

	@FindBy(how = How.ID, using = "user-name")
	private static WebElement usernameField;
	
	@FindBy(how = How.ID, using = "password")
	private static WebElement passwordField;
	
	@FindBy(how = How.XPATH, using = "//input[@type='password']")
	private static WebElement loginBtn;

	SeleniumUtils seleniumUtils;

	public LoginPage() {
		super(Setup.getDriver());
		seleniumUtils = new SeleniumUtils();

	}

	public void saisirUsername(String username) {
		seleniumUtils.clearField(usernameField);
		seleniumUtils.writeText(usernameField, username);

	}
	
	public void saisirPassword( String password) {
		seleniumUtils.clearField(passwordField);
		seleniumUtils.writeText(passwordField, password);
	}
	public void cliquerLoginBtn() {
		seleniumUtils.click(loginBtn);
	}

	public String getHomeURL() {
	String url= seleniumUtils.getCurrentUrl();
	System.out.println(url);
	 return url;
	}
}
