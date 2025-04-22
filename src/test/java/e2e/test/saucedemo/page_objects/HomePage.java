package e2e.test.saucedemo.page_objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import e2e.test.saucedemo.utils.BasePage;
import e2e.test.saucedemo.utils.SeleniumUtils;
import e2e.test.saucedemo.utils.Setup;

public class HomePage extends BasePage {

	@FindBy(how = How.CSS, using = ".product_sort_container")
	private static WebElement sortingDropDown;
	@FindBy(how = How.CSS, using = ".product_sort_container")
	private static WebElement containerDropDown;
	@FindBy(how = How.CSS, using = ".inventory_item_price")
	private static List<WebElement> productPrice;
	@FindBy(how = How.CSS, using = ".inventory_item_name ")
	private static List<WebElement> listProductNames;

	SeleniumUtils seleniumUtils;

	public HomePage() {
		super(Setup.getDriver());
		seleniumUtils = new SeleniumUtils();
	}

	public void cliqueChoixDropDown(String choix) {
		seleniumUtils.click(sortingDropDown);
		Select dropDownChoise = new Select(containerDropDown);
		dropDownChoise.selectByVisibleText(choix);
	}

	public List<Double> getProductPrices() {
		List<Double> prices = new ArrayList<>();
		for (WebElement prixElement : productPrice) {
			String price = prixElement.getText().replaceAll("[^\\d.]", "");
			prices.add(Double.parseDouble(price));
		}
		return prices;
	}

	public Boolean isPriceSortedAscending() {
		List<Double> actualPrices = getProductPrices();
		List<Double> triPrices = new ArrayList<>(actualPrices);
		Collections.sort(triPrices);
		System.out.println("Affiché     : " + actualPrices);
		System.out.println("Attendu ↑   : " + triPrices);
		return actualPrices.equals(triPrices);

	}

	public Boolean isPriceSortedDescending() {
		List<Double> actualPricesList = new ArrayList<>();
		for (WebElement price : productPrice) {
			String prix = price.getText().replaceAll("[^\\d.]", "");
			actualPricesList.add(Double.parseDouble(prix));
		}
		List<Double> desortedPrices = new ArrayList<>(actualPricesList);
		Collections.sort(desortedPrices, Collections.reverseOrder());
		System.out.println("Expected ↑   : " + actualPricesList);
		System.out.println("Acual ↑   : " + desortedPrices);
		return actualPricesList.equals(desortedPrices);
	}

	public Boolean sortedProductZtoA() {
		List<String> productNames = new ArrayList<>();
		for (WebElement nameElement : listProductNames) {
			productNames.add(nameElement.getText());

		}
		List<String> sortedNames = new ArrayList<>(productNames);
		sortedNames.sort(Comparator.reverseOrder());
		System.out.println("Affiché     : " + productNames);
		System.out.println("Attendu Z-A : " + sortedNames);

		return productNames.equals(sortedNames);
	}
	
	public Boolean sortedProductAToA(){
	 List<String> actualListNameProduct=new ArrayList<>();
		for(WebElement name : listProductNames) {
			actualListNameProduct.add(name.getText());
		}
		List <String> sortedAtoZ = new ArrayList<>(actualListNameProduct);
		sortedAtoZ.sort(Comparator.naturalOrder());
		return actualListNameProduct.equals(sortedAtoZ);
	}

}