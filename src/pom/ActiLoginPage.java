package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This Class Contains all the elements of LoginPage of ActiTIME app
 * @author Raghav
 *
 */
public class ActiLoginPage {

	@FindBy(id="username")
	private WebElement unTB;
	public void setUsername(String un)
	{
		unTB.sendKeys(un);
	}
	
	
	@FindBy(name="pwd")
	private WebElement pwTB;
	public void setPassword(String pwd)
	{
		pwTB.sendKeys(pwd);
	}
	
	
	@FindBy(xpath="//div[.='Login ']")
	private WebElement loginBtn;
	public void clickLoginBtn()
	{
		loginBtn.click();
	}
	
	public ActiLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
	
	
	
	
	
}
