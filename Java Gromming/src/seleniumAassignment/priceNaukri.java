package seleniumAassignment;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import basic_settings.Basic_Settings;

public class priceNaukri extends Basic_Settings{

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.naukri.com/");
		
		WebElement servicesTab = driver.findElement(By.xpath("//div[@class='mTxt' and text()='Services']"));
		Actions action = new Actions(driver);
		action.moveToElement(servicesTab);
		action.perform();
		
		WebElement marketingTab = driver.findElement(By.linkText("Marketing"));
		Thread.sleep(1000);
		marketingTab.click();		

		ArrayList<Object> tabs = new ArrayList<Object> (driver.getWindowHandles());
		driver.switchTo().window((String) tabs.get(1));
		
		WebElement brandButton = driver.findElement(By.xpath("//a[@class='tag' and text()='Brand Management']"));
		brandButton.click();
		
		WebElement priceTab = driver.findElement(By.xpath("//span[text()='Price']"));
		priceTab.click();

		WebElement leftSlider = driver.findElement(By.xpath("(//button[@class='handle'])[1]"));
		int xLeft = leftSlider.getSize().width;
		action.dragAndDropBy(leftSlider, xLeft*2, 0);	
		
		
		WebElement rightSlider = driver.findElement(By.xpath("((//button[@class='handle'])[2]"));
		int xRight = rightSlider.getSize().width;
		action.dragAndDropBy(rightSlider, xRight*2, 0);	
		
		WebElement applyButton = driver.findElement(By.xpath("//span[@class=\"button-text \" and text()=\"Apply\"]"));
		applyButton.click();
		
		
	}
}
