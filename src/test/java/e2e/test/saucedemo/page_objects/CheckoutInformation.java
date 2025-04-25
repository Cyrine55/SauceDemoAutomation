package e2e.test.saucedemo.page_objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import e2e.test.saucedemo.utils.BasePage;
import e2e.test.saucedemo.utils.SeleniumUtils;
import e2e.test.saucedemo.utils.Setup;

public class CheckoutInformation extends BasePage{
	@FindBy(how = How.ID, using = "first-name")
	private static WebElement firstnameField ;
	@FindBy(how = How.ID, using = "last-name")
	private static WebElement lastnameField ;
	@FindBy(how = How.ID, using = "postal-code")
	private static WebElement postalCodeField ;
	@FindBy(how = How.ID, using = "continue")
	private static WebElement continueBtn ;
	
    SeleniumUtils seleniumUtils;
    
    
    
	public CheckoutInformation() {
		super(Setup.getDriver());
		seleniumUtils = new SeleniumUtils();
	
	}
	
	public void addChekoutFirstname(String firstnameText) {
		seleniumUtils.writeText(firstnameField, firstnameText);
		//firstnameField.sendKeys(firstnameText);
		
	}
	public void addChekoutLastname(String lastnameText) {
		seleniumUtils.writeText(lastnameField, lastnameText);
		
		
	}
	public void addChekoutPostalCode(String postalcodeText) {
		seleniumUtils.writeText(postalCodeField, postalcodeText);
		
	}
	
	public void cliquerSurContinue() {
		seleniumUtils.click(continueBtn);
	}
	public String getcheckoutStep2Url() {
		return  seleniumUtils.getCurrentUrl();
	}
	

}
