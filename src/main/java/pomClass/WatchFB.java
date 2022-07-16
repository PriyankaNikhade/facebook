package pomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WatchFB {
	
	@FindBy (xpath="(//a[@href='/watch/live/?ref=watch'])[1]")
	private WebElement live;
	
	//Contructor call using same cls so we used this keyword
	public WatchFB(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	//	driver=driver
				
	}
	
	//Method created
	public void clickOnLive() {
		live.click();
	}

}
