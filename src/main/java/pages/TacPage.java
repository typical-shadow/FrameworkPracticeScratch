package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import AbstractComponents.CommonComponents;

public class TacPage extends CommonComponents {

	WebDriver driver;

	public TacPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//select")
	WebElement dropdown;
	
	@FindBy(className = "chkAgree")
	WebElement checkBox;
	
	@FindBy(xpath = "//button[text()='Proceed']")
	WebElement proceedBtn;
	
	public void selectCountryDropDown(String country) {
		Select select = new Select(dropdown);
		select.selectByValue(country);
	}
	
	public void acceptTermsAndCondition()
	{
		checkBox.click();
	}
	
	public void confirmOrder()
	{
		proceedBtn.click();
	}
	
}
