package e2e.test.saucedemo.page_objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import e2e.test.saucedemo.utils.BasePage;
import e2e.test.saucedemo.utils.SeleniumUtils;
import e2e.test.saucedemo.utils.Setup;

public class HomePage extends BasePage{

	@FindBy(how = How.CSS, using = ".product_sort_container")
	private static WebElement sortingDropDown;
	@FindBy(how = How.CSS, using = ".product_sort_container")
	private static WebElement containerDropDown;
	@FindBy(how = How.CSS, using = ".inventory_item_price")
	private static List<WebElement> productPrice;
	
	
	
	
	SeleniumUtils seleniumUtils;
	
	
	public HomePage() {
		super(Setup.getDriver());
		seleniumUtils = new SeleniumUtils();
	}

	public void cliqueChoixDropDown(String choix) {
		seleniumUtils.click(sortingDropDown);
		Select dropDownChoise=new Select(containerDropDown);
		dropDownChoise.selectByVisibleText(choix);
	}
	
	public List <Double>  getProductPrices() {
		  List<Double> prices = new ArrayList<>();
		for(WebElement prixElement:productPrice) {
			String price=prixElement.getText().replaceAll("[^\\d.]", "");
			prices.add(Double.parseDouble(price));
		}
		return prices;
	}
	
	public Boolean isPriceSortedAscending() {
		List <Double> actualPrices=getProductPrices();
		List <Double> triPrices=new ArrayList<>(actualPrices);
		Collections.sort(triPrices);
		 return actualPrices.equals(triPrices);
	}
	
	public Boolean isPriceSortedDescending() {
		List <Double> actualPrices=getProductPrices();
		List <Double> desortedPrices=new ArrayList<>(actualPrices);
		Collections.sort(desortedPrices, Collections.reverseOrder());
		
			return actualPrices.equals(desortedPrices);
		
	}
	
}
