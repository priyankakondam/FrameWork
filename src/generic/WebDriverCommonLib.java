package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains common controls of WebDriver Interface
 * @author Raghav
 *
 */
public class WebDriverCommonLib extends BaseTest {

	/**
	 * This method is used to wait for the page to load 
	 * polling after every 500ms for maximum of 20 seconds 
	 */
	public void waitForPageLoad()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	/**
	 * This method is used to wait for the element to be visible on the GUI
	 * polling after every 500ms for maximum of 20 seconds
	 * @param locator
	 */
	public void waitForVisibilityOfElement(By locator)
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	/**
	 * This method is used for selecting any option from a dropdown 
	 * By using visible Text
	 * @param element
	 * @param text
	 */
	public void select(WebElement element, String text)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	
	/**
	 * This method is used for selecting any option from a dropdown 
	 * By using Index
	 * @param element
	 * @param text
	 */
	public void select(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	
	/**
	 * This method is used to perform mouse hover action on any element
	 * @param element
	 */
	public void mouseHover(WebElement element)
	{
		Actions ac=new Actions(driver);
		ac.moveToElement(element).perform();
	}
	
	
	
	
	
	
	
}
