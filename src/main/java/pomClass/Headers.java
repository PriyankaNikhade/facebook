package pomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Headers {

	@FindBy (xpath="//a[@aria-label='Home']")
	private WebElement home;
	
	@FindBy (xpath="(//li[contains(@class,'buofh1pr to382e16')]//a)[2]")
	private WebElement friendsfb;
	
	@FindBy (xpath="(//li[contains(@class,'buofh1pr to382e16')]//a)[3]")
	private WebElement watch;
		
	@FindBy (xpath="(//li[contains(@class,'buofh1pr to382e16')]//a)[4]")
	private WebElement marketplace;
	
	@FindBy (xpath="(//li[contains(@class,'buofh1pr to382e16')]//a)[6]")
	private WebElement more;
	
	//logout button dropdown
	@FindBy (xpath ="(//div[contains(@class,'ehxjyohh')][2]//div)[2]")
	private WebElement dropdown;

	@FindBy (xpath="//span[text()='Log Out']")
	private WebElement logout; 
		
	
	//constructor public bcz we need to fetch data in other package or cls
	public Headers(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//all methods of heder 
	public void clickOnHome() {
		home.click();
	}
	public void clickOnFriends() {
		friendsfb.click();
	}
	public void clickOnWatch() {
		watch.click();
	}
	public void clickOnMarketPlace() {
		marketplace.click();
	}
	public void clickOnMore() {
		more.click();
	}
	
	public void logOutFB()
	{//Method logoutToFaceBook
		
		dropdown.click();
		
		logout.click();
	}
	
	
	
	
	
	
}
