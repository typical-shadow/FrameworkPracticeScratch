package AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.CartPage;

public class CommonComponents {

	public WebDriver driver;

	public CommonComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "img[alt='Cart']")
	WebElement cartIcon;

	@FindBy(xpath = "//div[@class='action-block']/button")
	WebElement proceedButton;

	public void clickOnCartIcon() {
		cartIcon.click();
	}

	public CartPage clickOnProceed() {
		proceedButton.click();
		return new CartPage(driver);
	}
	
	public void waitForElementAppearLocator(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}
	

	

}
