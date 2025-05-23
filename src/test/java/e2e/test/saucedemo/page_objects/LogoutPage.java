package e2e.test.saucedemo.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import e2e.test.saucedemo.utils.BasePage;
import e2e.test.saucedemo.utils.SeleniumUtils;
import e2e.test.saucedemo.utils.Setup;

public class LogoutPage extends BasePage {

	@FindBy(how = How.ID, using = "react-burger-menu-btn")
	private static WebElement menuBtn;
	@FindBy(how = How.XPATH, using = "//a[@id='logout_sidebar_link']")
	private static WebElement logoutBtn;
	
	SeleniumUtils seleniumUtils;

	public LogoutPage() {
		super(Setup.getDriver());
		seleniumUtils = new SeleniumUtils();

	}

	public void cliqueSurMenu() {
		seleniumUtils.mouseHover(menuBtn);
	}

	public void clickonLogOutBtn() {

		seleniumUtils.clickOnElementUsingJs(logoutBtn);
	}
	
	public String getCurrentUrl() {
		return seleniumUtils.getCurrentUrl()	;
	
	}
}
