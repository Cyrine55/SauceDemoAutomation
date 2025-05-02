package e2e.test.saucedemo.page_objects;



import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import e2e.test.saucedemo.utils.BasePage;
import e2e.test.saucedemo.utils.SeleniumUtils;
import e2e.test.saucedemo.utils.Setup;

public class CheckoutOverviewPage extends BasePage{
	
	@FindBy(how = How.CSS, using = ".inventory_item_price")
	private static List<WebElement> priceList;
	@FindBy(how = How.CSS, using = ".summary_total_label")
	private static WebElement finalPrice;
	
	
	
	
	
	
	SeleniumUtils seleniumUtils;
	private static final Logger LOGGER = LogManager.getLogger(AddProductInCart.class);
	public CheckoutOverviewPage() {
		super(Setup.getDriver());
		seleniumUtils= new SeleniumUtils();
		
	}
	
	public List<String> getProductPrices() {
		 List<String> pricesText = new ArrayList<>();
		for(WebElement prices:priceList) {
			String price = prices.getText().replaceAll("[^\\d.]", "").replace(",", ".").trim();
			pricesText.add(price);
			
		}
		System.out.println(pricesText);
		return pricesText;
	}
	public double getDisplayedPrice() {
		 String totalText = finalPrice.getText();
		 totalText=totalText.replaceAll("[^\\d.,]", "").replace(",", ".");
	 System.out.println(totalText);
		 return Double.parseDouble(totalText);
		
	}
	
	public double getPrices() {
		List<String> productPrices= getProductPrices();
		double totalPrice=0.0;
		double tax = 0.64;
		for(String priceStr:productPrices) {
			priceStr = priceStr.replaceAll("[^\\d.,]", ""); // Supprime les caractères non numériques
			priceStr = priceStr.replace(",", "."); // Convertit les virgules en points si besoin
			try {
				double price=Double.parseDouble(priceStr);
				totalPrice +=price;
			}
			catch(NumberFormatException e) {
	            System.out.println("Erreur de conversion pour le prix : " + priceStr);
	        }
		}
		 totalPrice += tax;
	    System.out.println("Somme totale des prix : " + totalPrice);
	    return totalPrice;
	}
}
