package seleniumInterviewTY;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basic_settings.Basic_Settings;

public class WindowHandle extends Basic_Settings{
	
	public void newTab() throws AWTException {
		Robot rbt = new Robot();
		rbt.keyPress(KeyEvent.VK_CONTROL);
		rbt.keyPress(KeyEvent.VK_T);		
		rbt.keyRelease(KeyEvent.VK_CONTROL);
		rbt.keyRelease(KeyEvent.VK_T);
	}

	public static void main(String[] args) throws AWTException {
		WindowHandle newWin = new WindowHandle();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		newWin.newTab();
		newWin.newTab();
		newWin.newTab();
		
		int tabNo = driver.getWindowHandles().size();
		System.out.println("Number of open Tabs : "+tabNo);		
		
		ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(1));
		driver.get("https://www.flipkart.com/");
		wait.until(ExpectedConditions.titleContains("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!"));

		driver.switchTo().window(windowHandles.get(2));
		driver.get("https://www.amazon.in/");
		wait.until(ExpectedConditions.titleContains("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"));
		
		driver.switchTo().window(windowHandles.get(3));
		driver.get("https://www.bewakoof.com/");
		wait.until(ExpectedConditions.titleContains("Online Shopping for Men, Women Clothing & Accessories at Bewakoof"));
		String expetedTitle = driver.getTitle();
		
		driver.switchTo().window(expetedTitle);
		System.out.println(expetedTitle);
		
		Set<String> alltabs = driver.getWindowHandles();
		
		for (String tab : alltabs) {
			String tabTitle = driver.getTitle();
			System.out.println(tabTitle);
			if (tabTitle.contains(expetedTitle)) {				
				driver.switchTo().window(tab);				
				driver.close();
			}		
		}
	}
}