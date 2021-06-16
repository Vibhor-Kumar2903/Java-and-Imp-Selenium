package seleniumAassignment;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import basic_settings.Basic_Settings;

public class NaukriWindowHandle extends Basic_Settings{

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.naukri.com/");

		String parent = driver.getWindowHandle();

		Set<String> allWindows = driver.getWindowHandles();
		System.out.println("Number of windows : "+allWindows.size());

		for (String child : allWindows) {
			if (!parent.equals(child)) {
				driver.switchTo().window(child);
				driver.close();		
			}			
		}
		driver.switchTo().window(parent);		
	}
}	