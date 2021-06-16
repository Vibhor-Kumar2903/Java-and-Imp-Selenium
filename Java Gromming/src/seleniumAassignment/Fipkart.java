package seleniumAassignment;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import basic_settings.Basic_Settings;

public class Fipkart extends Basic_Settings{

	WebDriver driver = null;
	void flipkart() {
		List<WebElement> productName = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		List<WebElement> ProductPrice = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));

		String product;
		String price;
		int integerPrice;

		HashMap<Integer, String> showProduct = new HashMap<Integer, String>();

		for (int i = 0; i < productName.size(); i++) {
			product = productName.get(i).getText();
			price = ProductPrice.get(i).getText();
			price = price.replaceAll("[^0-9]","");
			integerPrice = Integer.parseInt(price);
			showProduct.put(integerPrice, product);
		}

		System.out.println("Product Name and Price fetched from UI and saved in HashMap as : "+showProduct.toString());
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");

		WebElement popUp = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		popUp.click();

		WebElement searchBar = driver.findElement(By.name("q"));
		searchBar.sendKeys("iphone x");

		WebElement searchButton = driver.findElement(By.xpath("//button[@class='L0Z3Pu']"));
		searchButton.click();

		List<WebElement> pages = driver.findElements(By.xpath("//a[@class='ge-49M']"));
		
		Fipkart obj = new Fipkart();

		for (int i = 0; i <= pages.size() +1; i++) {
			obj.flipkart();
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			Thread.sleep(2000);
			break;
		}		
	}
}