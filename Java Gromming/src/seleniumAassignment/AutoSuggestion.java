package seleniumAassignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import basic_settings.Basic_Settings;

public class AutoSuggestion extends Basic_Settings{

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		
	 	WebElement searchBar = driver.findElement(By.name("q"));
	 	searchBar.sendKeys("elon");
	 	
	 	List<WebElement> allSuggetion = driver.findElements(By.xpath("//div[@class='wM6W7d']//span[contains(text(),'elon')]"));
		System.out.println("Total number of suggestions : "+allSuggetion.size());
	 	
		for (WebElement sugg : allSuggetion) {
			System.out.println(sugg.getText());
		}		
	 	
	 	for (WebElement sugg : allSuggetion) {
	 		if (sugg.getText().contains("musk net worth")) {
	 			sugg.click();
	 			break;
			}
		}
	}
}