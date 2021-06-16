package seleniumInterviewTY;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import basic_settings.Basic_Settings;

public class TakeScreenShot extends Basic_Settings{
	
	public void webShot(WebDriver driver) throws IOException {
		
		String dateStamp = Calendar.getInstance().getTime().toString().replace(" ", ".").replace(":", ".");
		System.out.println("Date Stamp : "+dateStamp);			
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./screenshot/"+dateStamp+".png");
		FileUtils.copyFile(srcFile, destFile);
	}
	
	public void elementShot(WebElement element) throws IOException {
		
		String dateStamp = Calendar.getInstance().getTime().toString().replace(" ", ".").replace(":", ".");
		System.out.println("Date Stamp : "+dateStamp);		
		
		File srcFile = element.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./screenshot/"+dateStamp+".png");
		FileUtils.copyFile(srcFile, destFile);
	}
	
	public static void main(String[] args) throws IOException {
//		Calendar cal = Calendar.getInstance();
//		Date date = cal.getTime();
//		System.out.println(date);
		
//		LocalDateTime ldt = LocalDateTime.now();
//		String strdate = ldt.toString().replace(":", "_");
//		System.out.println(strdate);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		TakeScreenShot ts = new TakeScreenShot();		
		
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		ts.webShot(driver);
		
		WebElement image1 = driver.findElement(By.xpath("(//img[@class='kJjFO0 _3DIhEh'])[4]"));
	    ts.elementShot(image1);
	}
}