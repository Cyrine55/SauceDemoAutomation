package e2e.test.saucedemo.page_objects;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import e2e.test.saucedemo.utils.BasePage;
import e2e.test.saucedemo.utils.SeleniumUtils;
import e2e.test.saucedemo.utils.Setup;

public class CheckoutComplete extends BasePage{
SeleniumUtils seleniumUtils;


@FindBy(how = How.ID, using = "finish")
private static WebElement finishBtn;
@FindBy(how = How.CSS, using = ".complete-header")
private static WebElement successFinalMsg;

	public CheckoutComplete() {
		super(Setup.getDriver());
		seleniumUtils = new SeleniumUtils();
		
	}
	public void clickOnFinishBtn() {
		seleniumUtils.click(finishBtn);
	}
	
	public String getFinalSuccessMsg() {
		String finalMsg=successFinalMsg.getText();
		return finalMsg;
	}
	
}
