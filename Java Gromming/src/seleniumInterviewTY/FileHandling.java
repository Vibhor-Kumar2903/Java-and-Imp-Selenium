package seleniumInterviewTY;

import java.io.File;
import java.io.IOException;

public class FileHandling {

	public static void main(String[] args) throws IOException {
//		(creating file in a particular folder)
//		File f = new File("C:\\Users\\Vibhor\\Desktop\\Selenium Data\\FileHandling.txt");
//		f.createNewFile();
//		System.out.println("File created...");
		
		//creating a new folder 
		File f = new File("C:\\Users\\Vibhor\\Desktop\\File Handling");
		f.mkdir();
		System.out.println("Folder created");
		
		//creating a new file in created folder
		File f1 = new File(f,"file_handling.txt");
		f1.createNewFile();
		
		if (f1.exists()) {
			System.out.println("file created");
		}else {
			System.out.println("file not created");
		}
		
		//to know the directory of the file
		String absolutePath = f1.getAbsolutePath();
		System.out.println("Path of file created :- "+absolutePath);
		
		// to check all files and its name in File Handling folder (also the number of folder)
		String[] list = f.list();
		for (String files : list) {
			System.out.println(files);
		}		
		System.out.println("Total file present in File Hnadling folder : "+list.length);
	}
}
