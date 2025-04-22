package e2e.test.saucedemo.page_objects;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import e2e.test.saucedemo.utils.BasePage;
import e2e.test.saucedemo.utils.SeleniumUtils;
import e2e.test.saucedemo.utils.Setup;

public class AddProductInCart extends BasePage {
	@FindBy(how = How.CSS, using = ".btn.btn_primary")
	private static List<WebElement> listAddToCartBtn;
	@FindBy(how = How.XPATH, using = "//*[contains(@class, 'btn btn_primary')]")
	private static WebElement cartBtn;
	@FindBy(how = How.XPATH, using = "//a[@class='shopping_cart_link']")
	private static WebElement panierBtn;
	@FindBy(how = How.CSS, using = ".inventory_item_name ")
	private static List<WebElement> productsNameList;

	SeleniumUtils seleniumUtils;

	public AddProductInCart() {
		super(Setup.getDriver());
		seleniumUtils = new SeleniumUtils();
	}

	public void clickOnAddToCart(int index) {
		System.out.println(listAddToCartBtn.size());
		if (index >= 0 && index < listAddToCartBtn.size()) {
			WebElement btn = listAddToCartBtn.get(index);
			seleniumUtils.click(btn);

		}
	}

	public void clickOnPanierBtn() {
		seleniumUtils.click(panierBtn);
	}

	public void addProductWithName(String productName) {
		for (int i = 0; i < productsNameList.size(); i++) {
			String nameProduit = productsNameList.get(i).getText().trim();
			if (nameProduit.equalsIgnoreCase(productName)) {
				System.out.println("Nom produit trouvé : " + nameProduit);
				System.out.println("Bouton associé : " + listAddToCartBtn.get(i).getText());
				WebElement btn = listAddToCartBtn.get(i);
				seleniumUtils.click(btn);
			}
		}
	}

	public void addManyProducts(String produits) {
		List<String> produitsList = Arrays.asList(produits.split(","));
		for (String prod : produitsList) {
			for (int i = 0; i < productsNameList.size(); i++) {
				String nameProduit = productsNameList.get(i).getText().trim();
				if (nameProduit.equalsIgnoreCase(prod.trim())) {
					System.out.println("Produit trouvé : " + nameProduit);
					seleniumUtils.click(listAddToCartBtn.get(i));
					break;
				}
			}

		}

	}

}
