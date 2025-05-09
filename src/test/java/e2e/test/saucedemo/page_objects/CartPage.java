package e2e.test.saucedemo.page_objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import e2e.test.saucedemo.utils.BasePage;
import e2e.test.saucedemo.utils.SeleniumUtils;
import e2e.test.saucedemo.utils.Setup;

public class CartPage extends BasePage {

	@FindBy(how = How.XPATH, using = "//div[normalize-space()='Sauce Labs Fleece Jacket']")
	private static WebElement oneProduct;
	@FindBy(how = How.CSS, using = ".cart_quantity")
	private static WebElement onequantity;
	@FindBy(how = How.CSS, using = ".inventory_item_name")
	private static WebElement pdtName;

	@FindBy(how = How.CSS, using = ".inventory_item_name")
	private static List<WebElement> listName;
	@FindBy(how = How.ID, using = "checkout")
	private static WebElement checkoutBtn;

	@FindBy(how = How.CSS, using = ".btn_small.cart_button")
	private List<WebElement> listRemoveBtn;

	SeleniumUtils seleniumUtils;

	public CartPage() {
		super(Setup.getDriver());
		seleniumUtils = new SeleniumUtils();
	}

	public Boolean productIsDisplayed() {
		return oneProduct.isDisplayed();
	}

	public Boolean onequantityIsDisplayedonCarte() {
		return onequantity.isDisplayed() && onequantity.getText().trim().equals("1");
	}

	public String pdpNameIsDisplayedonCarte() {
		String actualPdtName = pdtName.getText();
		return actualPdtName;
	}

	public List<String> getProductNameOnCart() {
		List<String> NamesPdt = new ArrayList<String>();
		for (WebElement names : listName) {
			NamesPdt.add(names.getText().trim());

		}
		return NamesPdt;
	}

	public boolean verifyProductsInCart(String produits) {
		List<String> produitsList = Arrays.asList(produits.split(","));
		List<String> produitsAffiches = getProductNameOnCart();

		for (String produitAttendu : produitsList) {
			boolean produitTrouve = false;
			for (String produitsAffiche : produitsAffiches) {
				if (produitAttendu.trim().equalsIgnoreCase(produitsAffiche.trim())) {
					produitTrouve = true;
					break;
				}
			}
		}
		return true;

	}

	public void clickCheckoutBtn() {
		seleniumUtils.click(checkoutBtn);
	}

	public void removeProduit(String produit) {
		List<String> removeBtnList = new ArrayList<String>();
		List<String> nameproduits = getProductNameOnCart();
		for (WebElement removes : listRemoveBtn) {
			String removeBtn = removes.getText().trim();
			removeBtnList.add(removeBtn);
		}
		for (int i = 0; i < nameproduits.size(); i++) {
			if (nameproduits.get(i).equalsIgnoreCase(produit.trim())) {
				WebElement btnRemove = listRemoveBtn.get(i);
				seleniumUtils.click(btnRemove);
			}

		}
	}
	
	public boolean getproductRemoved(String produit) {
		List<String> nameproduits = getProductNameOnCart();
		for(String nom:nameproduits) {
			if (nom.equalsIgnoreCase(produit.trim())) {	
				return true;
			}
		}
		return false;
		
	}

}
