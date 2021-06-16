package seleniumAassignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basic_settings.Basic_Settings;

public class FlipkartRange extends Basic_Settings{

	public static void main(String[] args) {
	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.name("q")).sendKeys("iphone x",Keys.ENTER);
		
		String inventoryLine = driver.findElement(By.xpath("//span[starts-with(text(),'Showing')]")).getText();
		System.out.println(inventoryLine);
		
		String pageLine = driver.findElement(By.xpath("//span[contains(text(),'Page')]")).getText();
		String[] split = pageLine.split(" ");
		int totalPage = Integer.parseInt(split[3].replace(",", " "));
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		int count = 0;
		for (int i = 1; i <= totalPage; i++) {
			boolean flag = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[contains(text(),'Page')]"),("page "+i+" of "+totalPage)));			
		
			if(flag) {
				try {
					List<WebElement> allItem = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='_4rR01T']")));
					System.out.println("\n"+i+" Page element..");
					for (WebElement webElement : allItem) {
						System.out.print(webElement.getText());
						String price = driver.findElement(By.xpath("//div[text()= '"+webElement.getText()+"']/../../div[2]/div[1]/div[1]//div")).getText();
						System.out.println(" |------> "+price);
						
						if (i==totalPage) {
							break;
						}
						driver.findElement(By.xpath("//span[text()='Next']")).click();
					}					
				} catch (Exception e) {
					System.out.println("Exception occur");
				}
			}else {
				System.out.println("\n==============================================================================");
				System.out.println("Total product printed "+count);
				driver.close();
			}
		
		}
		
		
		
		
		
				
		
	}
}
