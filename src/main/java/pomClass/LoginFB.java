package pomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sun.tools.javac.util.Assert;

public class LoginFB {

	@FindBy(xpath = "//input[@name='email']")
	private WebElement emailId;

	@FindBy(xpath = "//input[@name='pass']")
	private WebElement password;

	@FindBy(xpath = "//button[text()='Log In']")
	private WebElement loginButton;

	@FindBy(xpath = "(//span[text()='Log In'])[1]")
	private WebElement loginButton1;

	@FindBy(xpath = "//span[text()='Priya Kale']")
	public WebElement userid;

	// constructor call
	public LoginFB(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

//	public void loginToFB() 
//	{// Method loginToFB1(String username)
//		emailId.sendKeys("9503136850"); //9503136850
//		password.sendKeys("Priyanka19@");//pass
//		loginButton.click();
//	}
	
	
	
	public void faceBookUsername(String username) {// Method loginToFaceBook
		emailId.sendKeys(username);
		
	}
	public void faceBookPassword(String pass) {// Method loginToFaceBook
		password.sendKeys(pass);
		loginButton.click();
	}
	
	
//	public void loginToFB1(String username) 
//	{// Method loginToFB1(String username)
//		emailId.sendKeys(username); //9503136850
////		password.sendKeys("Priyanka19@");//pass
////		loginButton1.click();
//	}
	public void loginToFB2(String pass) {// Method loginToFaceBook
		
	 //"Priyanka19@"
		password.sendKeys(pass);
		loginButton.click();
	}
	
	public void getuserid() {// Method

		String actuserId = userid.getText();
		String expUserid = "Priya Kale";
		
	//	Assert.assertEquals();
		if (actuserId.equals(expUserid)) {
			System.out.println("Pass1 Login name test case");
		} else {
			System.out.println("Failed1 Login name test case");
		}

	}

}