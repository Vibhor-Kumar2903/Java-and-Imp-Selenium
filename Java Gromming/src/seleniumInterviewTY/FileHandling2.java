package seleniumInterviewTY;

import java.io.File;

public class FileHandling2 {

	public static void main(String[] args) {
		//counting number of file and folder
		
		int countFile=0;
		int countFolder=0;
		
		File f = new File("D:\\Java_Program");
		
		boolean exist = f.exists();
		System.out.println("Given file directory exists : "+exist);
		
		String[] allItem = f.list();
		for (String item : allItem) {
			System.out.println(item);
		}
		System.out.println("Number of file and folders : "+allItem.length);

		for (String item : allItem) {
			File f1 = new File(f, item);
			if (f1.isDirectory()) {
				countFolder++;	
			}
			if (f1.isFile()) {
				countFile++;
			}
		}
		System.out.println("Number of file : "+countFile);
		System.out.println("Number of folder : "+countFolder);
	}
}