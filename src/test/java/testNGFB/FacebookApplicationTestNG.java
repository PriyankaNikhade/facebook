package testNGFB;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import crossBrowser.Base;
import pomClass.FriendsFB;
import pomClass.Headers;
import pomClass.LoginFB;
import pomClass.MarketPlace;
import pomClass.WatchFB;
import utility.UtilityClass1;

public class FacebookApplicationTestNG {
	 
	//Global variable declared.
	WebDriver driver;
	Headers header;
	LoginFB loginfb;
	FriendsFB freind;
	WatchFB watch;
	MarketPlace marketplace;
	int testCId; //test case id number.
	
	@Parameters("browserName")
	@BeforeTest   //argument pass from testng suite value browser object pass here for launching the browser
	public void browserLaunch(String browser)
	{
		// multiple browser launch code here
		if (browser.equals("Chrome")) {
			driver = Base.openChromeBrowser();
		}
		if (browser.equals("Edge")) {
			driver = Base.openEdgeBrowser();
		}
		if (browser.equals("Firefox")) {
			driver = Base.openFirefoxBrowser();
		}

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@BeforeClass
	public void allPomClassObjectCreate() 
	{ 
		//All pom classes object created here
		loginfb = new LoginFB(driver);
		header = new Headers(driver);
		freind = new FriendsFB(driver);
		watch = new WatchFB(driver);
		marketplace = new MarketPlace(driver);
	}

	@BeforeMethod
	public void loginFB() throws EncryptedDocumentException, IOException
	{	//browser url launch
		driver.get("https://www.facebook.com/");
		String userName = UtilityClass1.getDataFromExcel("Sheet1", 1, 0);
		loginfb.faceBookUsername(userName);
		String password = UtilityClass1.getDataFromExcel("Sheet1", 1, 1);
		loginfb.faceBookPassword(password);
		loginfb.getuserid(); // get text userid test case call here
	}

	@Test(priority = 1)
	public void verifyFriendsURL() throws InterruptedException {
		
		testCId=101;
		header.clickOnFriends();
		freind.clickOnFriendsRequest();

		Thread.sleep(2500);
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();

		System.out.println("FriendsFB URL : " + url);
		System.out.println("FriendsFB TITLE : " + title);

		Assert.assertEquals(url, "https://www.facebook.com/friends/requests");
		Assert.assertEquals(title, "Friend requests | Facebook");
	}

	@Test // (enabled=false,invocationCount = 2) //enabled=false<-----Method working
	public void verifyWatchLive() {
		testCId=102;
		header.clickOnWatch();
		watch.clickOnLive();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		System.out.println("WatchFB URL : " + url);
		System.out.println("WatchFB TITLE : " + title);

		Assert.assertEquals(url, "https://www.facebook.com/watch/?ref=tab");
		Assert.assertEquals(title, "Watch | Facebook", "Watch the facebook");
	}

	@Test(priority = 2) // dependsOnMethods= {"verifyFriendsURL"}
	public void verifyMarketPlace() {
		testCId=103;
		header.clickOnMarketPlace();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)", ""); // scroll down
		marketplace.clickOnElectronics();

		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		System.out.println("MarketPlace URL : " + url);
		System.out.println("MarketPlace TITLE : " + title);

		Assert.assertEquals(url, "https://www.facebook.com/marketplace/?ref=app_tab");
		Assert.assertEquals(title, "Facebook Marketplace | Facebook");
	}

	@AfterMethod
	public void logoutFromFaceBook(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			UtilityClass1.captureScreen(driver, testCId);		
		}
		header.logOutFB();
	}

	@AfterClass
	public void clearObject() {
		
		//object referance declared here null, so iske aage uska use nhi kar sakte.
		//driver = null; <---yaha driver ko null kiya tha to browser closed hua nhi 
		header = null;
		loginfb = null;
		freind = null;
		watch = null;
		marketplace = null;

	}

	@AfterTest
	public void closedBrowser() {
		driver.manage().deleteAllCookies();
		driver.quit();
		driver = null;  //<---yha driver ko null kiya to browser closed hua.
		System.gc(); // garbage collector memory clean remove object=null referances.
	}

}
