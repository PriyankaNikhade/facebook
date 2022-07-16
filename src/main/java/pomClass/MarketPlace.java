package pomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MarketPlace {
	
	@FindBy (xpath="(//span[text()='Electronics'])[1]")
	private WebElement electronics;
	
	//Contructor call using same cls so we used this keyword
	public MarketPlace(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void clickOnElectronics() {
		electronics.click();
	}

}
