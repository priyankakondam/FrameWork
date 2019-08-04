package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pom.ActiLoginPage;
import pom.EnterTimeTrackPage;

/**
 * This Class contains Pre-condition and Post Condition 
 * Used to open and close browser and application
 * @author Raghav
 *
 */
public class BaseTest {

	
	public WebDriver driver;
	FileLib fLib=new FileLib();
	
	/**
	 * This method is used to Open the required browser
	 * @throws Throwable
	 */
	@BeforeClass
	public void launchBrowser() throws Throwable
	{
		String browserValue =fLib.getPropertyKeyValue("browser");
		if(browserValue.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
		}
		else if(browserValue.equalsIgnoreCase("firefox")) {
		driver=new FirefoxDriver();
		}
		else
		{
System.out.println("check you have entered correct browser value.."
		+ "chrome/firefox");
		}
		driver.get(fLib.getPropertyKeyValue("url"));
	}
	
	/**
	 * This method is used to login to Application
	 * @throws Throwable 
	 */
	@BeforeMethod(enabled=false)
	public void loginToApp() throws Throwable
	{
		ActiLoginPage alp=new ActiLoginPage(driver);
		Thread.sleep(3000);
		alp.setUsername(fLib.getPropertyKeyValue("username"));
		Thread.sleep(3000);
		alp.setPassword(fLib.getPropertyKeyValue("password"));
		Thread.sleep(3000);
		alp.clickLoginBtn();
		
		
	}
	
	/**
	 * This method is used to logout from Application
	 */
	@AfterMethod(enabled=false)
	public void logoutFromApp()
	{
		EnterTimeTrackPage etp=new EnterTimeTrackPage(driver);
		etp.clickLogoutBtn();
	}
	
	/**
	 * This method is used to close all the browser windows
	 */
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
	
	
	
	
	
	
}
