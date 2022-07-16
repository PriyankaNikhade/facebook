package pomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FriendsFB {
	
	@FindBy (xpath = "//span[text()='Friend requests']")
	private WebElement friendsRequest;
	
//	@FindBy (xpath="")
//	private WebElement findFriendsButton;
	
	public FriendsFB(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickOnFriendsRequest() {
		friendsRequest.click();
		//findFriendsButton.click();
		
	}
}
