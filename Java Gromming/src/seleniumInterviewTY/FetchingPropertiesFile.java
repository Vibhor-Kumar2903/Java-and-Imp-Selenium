package seleniumInterviewTY;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FetchingPropertiesFile {

	public static void main(String[] args) throws IOException {
		//FileInputStream is use to read data from the file
		FileInputStream fis = new FileInputStream("./FileHandling/Data.properties");
		Properties p1 = new Properties();
		p1.load(fis);
		String name = p1.getProperty("Name");
		String occupation = p1.getProperty("Occupation");
		System.out.println(name);
		System.out.println(occupation);
		
		//FileInputStream is use to write data from the file
		
//		FileOutputStream fos = new FileOutputStream("./FileHandling/Data.properties");
//		Properties p2 = new Properties();
//		p2.store(fos, "Moon");
//		p2.setProperty("Moon", "Natural Satallite");
//		System.out.println(p2.getProperty("Moon"));
	}
}