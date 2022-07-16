package testNGFB;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import crossBrowser.Base;
import pomClass.Headers;
import pomClass.HomeFB;
import pomClass.LoginFB;
import pomClass.MarketPlace;

	public class HomeFBVerification {

		WebDriver driver;
		Headers hd;
		LoginFB lf;

		@BeforeClass
		public void BrowserLaunch() {
//			System.setProperty("webdriver.chrome.driver", "F:\\jar file\\chromedriver.exe");
//			driver = new ChromeDriver();
			driver=Base.openEdgeBrowser();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}

		@BeforeMethod
		public void loginFB() {
			driver.get("https://www.facebook.com/");
			driver.manage().window().maximize();
			lf = new LoginFB(driver);
	//		lf.loginToFB();
			lf.getuserid();     //get text userid test case call here
			hd = new Headers(driver);
		}

		
		@Test(priority = 0)
		public void homeFB() {
			hd.clickOnWatch();
			HomeFB hfb = new HomeFB(driver);
			hfb.clickOnFIcon();

			String url = driver.getCurrentUrl();
			String title = driver.getTitle();
			System.out.println("Home URL : " + url);
			System.out.println("Home TITLE : " + title);
			
			Assert.assertEquals(url,"https://www.facebook.com/");
			
			Assert.assertEquals(title,"Facebook");
			
//			if (url.equals("https://www.facebook.com/") && title.equals("Facebook")) {
//				System.out.println("PASS1");
//			} else {
//				System.out.println("FAILED1");
//			}
		}

		@Test(priority =1)
		public void verifyMarketPlace() {
			
			// Class 4 Run
			hd.clickOnMarketPlace();
			MarketPlace mp = new MarketPlace(driver);
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,700)", ""); //scroll down
			
			mp.clickOnElectronics();
		
			String url = driver.getCurrentUrl();
			String title = driver.getTitle();
			System.out.println("MarketPlace URL : " + url);
			System.out.println("MarketPlace TITLE : " + title);

			Assert.assertEquals(url,"https://www.facebook.com/marketplace/?ref=app_tab");
			Assert.assertEquals(title, "Facebook Marketplace | Facebook");
//			if (url.equals("https://www.facebook.com/marketplace/?ref=app_tab") && title.equals("Facebook Marketplace | Facebook")) {
//				System.out.println("PASS2");
//			} else {
//				System.out.println("FAILED2");
//			}

		}

		@AfterMethod
		public void logoutFromFaceBook() {
			hd.logOutFB();
		}

		@AfterClass
		public void closedBrowser() {
			driver.manage().deleteAllCookies();
			driver.quit();
		}

	}


