package runProgram;

import java.util.concurrent.TimeUnit;

import org.apache.bcel.classfile.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import LibraryFiles.UtilityClass;
import pomClass.FriendsFB;
import pomClass.Headers;
import pomClass.HomeFB;
import pomClass.LoginFB;
import pomClass.MarketPlace;
import pomClass.WatchFB;

public class FBMainRun {
	
	public static void main(String[] args) throws InterruptedException {
		//old code
		System.setProperty("webdriver.chrome.driver","F:\\jar file\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		LoginFB lf = new LoginFB(driver);
//		lf.loginToFBUsername();
//		lf.loginToFBpass(null);
//		lf.getuserid();
		
//		String emailId = Utility		
//		lf.loginToFBUsername(Utility.getTD("emailID",1,0));
//		lf.loginToFBpass(null)
		
		//class 1 run
		Headers hd = new Headers(driver);
		hd.clickOnFriends();	
		
		//class 2 run
		FriendsFB f = new FriendsFB(driver);
		f.clickOnFriendsRequest();
		
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		System.out.println("FriendsFB URL : "+url);
		System.out.println("FriendsFB TITLE : "+title);
			
		if(url.equals("https://www.facebook.com/friends/requests")&& title.equals("Friends | Facebook")) {
			System.out.println("PASS1");
		}else {
			System.out.println("FAILED1");
		}
			
		hd.logOutFB();
	//	lf.loginToFBUsername();
		hd.clickOnWatch();
		
		//Class 3 Run  
		WatchFB w = new WatchFB(driver);
		w.clickOnLive();
	
		url = driver.getCurrentUrl();
		title = driver.getTitle();
		System.out.println("WatchFB URL : "+url);
		System.out.println("WatchFB TITLE : "+title);
				
		if(url.equals("https://www.facebook.com/watch/shows")&& title.equals("Shows | Facebook")) {
			System.out.println("PASS2");
		}else {
			System.out.println("FAILED2");
		}
		
		hd.logOutFB();
	//	lf.loginToFB1();
		hd.clickOnMarketPlace();
		
		//Class 4 Run
		MarketPlace mp = new MarketPlace(driver);
		mp.clickOnElectronics();
		
		url = driver.getCurrentUrl();
		title = driver.getTitle();
		System.out.println("MarketPlace URL : "+url);
		System.out.println("MarketPlace TITLE : "+title);
		
		if(url.equals("https://www.facebook.com/friends")&& title.equals("Friends | Facebook")) {
			System.out.println("PASS3");
		}else {
			System.out.println("FAILED3");
		}
		
		hd.logOutFB();
//		lf.loginToFBUsername(Utility.getTD("emailId",1,0));
//		lf.loginToFBpass(Utility.getTD("Sheet1",1,1));
		hd.clickOnHome();
	
		//Class 5 Run
		HomeFB h = new HomeFB(driver);
		h.clickOnFIcon();
	
		url = driver.getCurrentUrl();
		title = driver.getTitle();
		System.out.println("HomeFB URL : "+url);
		System.out.println("HomeFB TITLE : "+title);
		
		if(url.equals("https://www.facebook.com/friends")&& title.equals("Friends | Facebook")) {
			System.out.println("PASS3");
		}else {
			System.out.println("FAILED3");
		}
		
		//class 1 run logut method call
		hd.logOutFB();
		
		driver.quit();
	}

}
