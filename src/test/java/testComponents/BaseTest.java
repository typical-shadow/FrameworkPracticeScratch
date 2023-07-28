package testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import pages.HomePage;

public class BaseTest {

	public WebDriver driver;
	public HomePage homePage;
	public Properties prop;
	public FileInputStream fis;
	
	public void initializeBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		String browser = "chrome";
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			
	}
	@BeforeMethod(alwaysRun = true)
	public void launchApplication() throws IOException {
		prop = new Properties();
		fis = new FileInputStream(System.getProperty("user.dir")+
				"\\src\\main\\java\\resource\\globalData.properties");
		initializeBrowser();
		homePage = new HomePage(driver);
		homePage.goTo(getGlobalProperty("url"));
		
				
	}
	
	public String getGlobalProperty(String propertie) throws IOException {
		
		prop.load(fis);
		return prop.getProperty(propertie);
		
	}
	
	public String getScreenshot(String testName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir")+"/TestReport/"+testName+".png");
		FileUtils.copyFile(source, destination);
		return System.getProperty("user.dir")+"/TestReport/"+testName+".png";
		
	}
	
	
}
