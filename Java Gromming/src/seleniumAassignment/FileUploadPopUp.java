package seleniumAassignment;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import basic_settings.Basic_Settings;

public class FileUploadPopUp extends Basic_Settings{

	public static void main(String[] args) throws AWTException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.naukri.com/");
		
		String parent = driver.getWindowHandle();
		
		Set<String> allWindows = driver.getWindowHandles();
		for (String child : allWindows) {
			if (!parent.equals(child)) {
				driver.switchTo().window(child);
				driver.close();
			}
		}
		
		driver.switchTo().window(parent);
		
		WebElement uploadButton = driver.findElement(By.xpath("//div[@class=\"wdgt-upload-btn\"]"));
		uploadButton.click();
		
		StringSelection path = new StringSelection("C:\\Users\\Vibhor\\Desktop\\Dox\\Resume.docx");
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard cb = toolkit.getSystemClipboard();
		
		cb.setContents(path, null);
		
		Robot robo = new Robot();
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
		
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyRelease(KeyEvent.VK_V);
		
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);		
	}
}