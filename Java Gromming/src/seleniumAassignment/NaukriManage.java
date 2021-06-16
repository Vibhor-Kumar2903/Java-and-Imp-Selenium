package seleniumAassignment;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basic_settings.Basic_Settings;

public class NaukriManage extends Basic_Settings{

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.naukri.com/");
		
		String parent = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		//System.out.println("Number of windows : "+allWindows.size());

		for (String child : allWindows) {
			if (!parent.equals(child)) {
				driver.switchTo().window(child);
				driver.close();		
			}			
		}
		driver.switchTo().window(parent);
		
		WebElement servicesTab = driver.findElement(By.xpath("//div[@class='mTxt' and text()='Services']"));
		Actions action = new Actions(driver);
		action.moveToElement(servicesTab);
		action.perform();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.linkText("Marketing"), "Marketing"));
		driver.findElement(By.linkText("Marketing")).click();;
		
		String win = driver.getWindowHandle();
		Set<String> allWin = driver.getWindowHandles();
		for (String child : allWin) {
			if (!win.equals(child)) {
				driver.switchTo().window(child);		
			}			
		}
				
		List<WebElement> course = driver.findElements(By.xpath("//div[@class='tags-container']//a[@class='tag']"));
		for (WebElement list : course) {
			System.out.println(list.getText());
		}
		
		WebElement brandButton = driver.findElement(By.xpath("//a[@class='tag' and text()='Brand Management']"));
		brandButton.click();
		
		WebElement pageBeforePriceSet = driver.findElement(By.xpath("//div[@class='pagination-container']//div[2]//a[last()-1]"));
		System.out.println("Total number of page before price set : "+pageBeforePriceSet.getText());
		
		WebElement priceButton = driver.findElement(By.xpath("//span[text()='Price']"));
		priceButton.click();
		 
		WebElement sliderStart = driver.findElement(By.xpath("//button[@class='handle'][1]"));
		action.dragAndDropBy(sliderStart, 80, 0);
		action.perform();
		 
		WebElement sliderEnd = driver.findElement(By.xpath("//button[@class='handle'][2]"));
		action.dragAndDropBy(sliderEnd, -80, 0);
		action.perform();

		WebElement applyButton = driver.findElement(By.xpath("//span[text()='Apply']"));
		applyButton.click();
		
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[@class='clear-all']"), "Clear All"));
		 
		while(true) {
			String pageAfterPriceSet = driver.findElement(By.xpath("//div[@class='pagination-container']//div[2]//a[last()-1]")).getText();
			if (pageBeforePriceSet.equals(pageAfterPriceSet)) {
				continue;
			}else {
				System.out.println("Page after price range : "+pageAfterPriceSet);
				break;
			}
		}		
	}
}