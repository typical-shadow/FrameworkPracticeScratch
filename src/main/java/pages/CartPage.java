package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.CommonComponents;

public class CartPage extends CommonComponents {


	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(className = "product-name")
	WebElement cartProducts;
	
	@FindBy(xpath = "//button[text()='Place Order']")
	WebElement placeOrderButton;
	
	
	
	public String getCartProduct() {
		return cartProducts.getText().split("-")[0].trim();
	}
	
	public TacPage placeOrder() {
		placeOrderButton.click();
		return new TacPage(driver);
	}
	
}
