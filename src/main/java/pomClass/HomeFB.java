package pomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeFB {
	
	@FindBy (xpath="//a[@aria-label='Facebook']")
	private WebElement fIconclick;

	@FindBy (xpath="//div[@aria-label='New Message']")
	private WebElement newMessage;
	
	public HomeFB(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	//	Actions a = new Actions(driver); 
	}

	public void clickOnFIcon() {
		fIconclick.click();
		newMessage.click();
	}
}
	
	
	

