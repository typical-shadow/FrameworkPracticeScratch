package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import pages.TacPage;
import testComponents.BaseTest;

public class PlaceOrderFlow extends BaseTest{

	
	public CartPage cartPage;
	public TacPage tacPage;
	
	@Test
	public void OrderFlowEndToEnd() throws IOException {

		
		//HomePage
		
		homePage.addProductToCart(getGlobalProperty("product"));

		homePage.clickOnCartIcon();
		cartPage = homePage.clickOnProceed();
		
		//CartPage
		String cartProductName = cartPage.getCartProduct();
		Assert.assertEquals(cartProductName, getGlobalProperty("product"));
		tacPage = cartPage.placeOrder();
		
		//TacPage
		tacPage.selectCountryDropDown(getGlobalProperty("country"));
		tacPage.acceptTermsAndCondition();
		tacPage.confirmOrder();
		
		Assert.assertEquals(homePage.getBlinkingText(), getGlobalProperty("blinkMessage"));
		System.out.println("Completed");
		
	}

}
