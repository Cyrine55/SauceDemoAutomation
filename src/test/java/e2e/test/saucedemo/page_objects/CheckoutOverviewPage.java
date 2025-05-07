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

public class CheckoutOverviewPage extends BasePage {

	@FindBy(how = How.CSS, using = ".inventory_item_price")
	private static List<WebElement> priceList;
	@FindBy(how = How.CSS, using = ".summary_total_label")
	private static WebElement finalPrice;

	SeleniumUtils seleniumUtils;
	private static final Logger LOGGER = LogManager.getLogger(AddProductInCart.class);

	public CheckoutOverviewPage() {
		super(Setup.getDriver());
		seleniumUtils = new SeleniumUtils();

	}

	public List<String> getProductPrices() {
		List<String> pricesText = new ArrayList<>();
		for (WebElement prices : priceList) {
			String price = prices.getText().replaceAll("[^\\d.]", "").replace(",", ".").trim();
			pricesText.add(price);
		}
		LOGGER.info("Liste des prix c'est : " + pricesText);
		return pricesText;
	}

	public double getDisplayedPrice() {
		String totalText = finalPrice.getText();
		totalText = totalText.replaceAll("[^\\d.,]", "").replace(",", ".");
		System.out.println(totalText);
		return Double.parseDouble(totalText);

	}

	public double itemTotalWithTaxe() {
		List<String> productPrices = getProductPrices();
		double totalPriceWithoutTax = 0.0;

		for (String priceStr : productPrices) {
			priceStr = priceStr.replaceAll("[^\\d.,]", "").replace(",", "."); // Supprime les caractères non numériques
																				// et les virgules
			try {
				double price = Double.parseDouble(priceStr);
				totalPriceWithoutTax += price;
			} catch (NumberFormatException e) {
				System.out.println("Erreur de conversion pour le prix : " + priceStr);
			}

		}
		double taxRate = 0.08;
		double tax = totalPriceWithoutTax * taxRate;
		double totalWithTax = totalPriceWithoutTax + tax;
		System.out.println("Sous-total (HT) : " + totalPriceWithoutTax);
		System.out.println("Taxe (8%) : " + tax);
		System.out.println("Total TTC : " + totalWithTax);
		return totalWithTax;
	}
}
