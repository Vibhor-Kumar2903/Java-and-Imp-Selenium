package seleniumAassignment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import basic_settings.Basic_Settings;

public class ClearTripTodate extends Basic_Settings{
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		System.out.println(date);
		
		cal.add(Calendar.DAY_OF_YEAR, 1);
		Date tomDate = cal.getTime();
		System.out.println(tomDate);
		
		SimpleDateFormat sdf = new SimpleDateFormat("E, dd MMM, yyyy");
		String formDate = sdf.format(tomDate);
		System.out.println(formDate);	
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.cleartrip.com/");		
		
		WebElement calendar = driver.findElement(By.id("DepartDate"));
		calendar.sendKeys(formDate, Keys.ENTER);		
	}
}