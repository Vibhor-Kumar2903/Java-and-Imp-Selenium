package seleniumAassignment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import basic_settings.Basic_Settings;

public class NaukriCourse extends Basic_Settings{

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.naukri.com/");
		
		WebElement servicesTab = driver.findElement(By.xpath("//div[@class='mTxt' and text()='Services']"));
		Actions action = new Actions(driver);
		action.moveToElement(servicesTab);
		action.perform();
		
		WebElement marketingTab = driver.findElement(By.linkText("Marketing"));
		marketingTab.click();
				
		ArrayList<Object> tabs = new ArrayList<Object> (driver.getWindowHandles());
		driver.switchTo().window((String) tabs.get(1));

		List<WebElement> courseList = driver.findElements(By.className("tag"));
		for (WebElement list : courseList) {
			String courseName = list.getText();
			System.out.println(courseName);
		}		
	}
}