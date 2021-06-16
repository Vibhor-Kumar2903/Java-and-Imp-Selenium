package seleniumInterviewTY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWritingAndReading {

	public static void main(String[] args) throws IOException {
		//Writing in file and Reading the file
		File f = new File("C:\\Users\\Vibhor\\Desktop\\File Handling");
		f.mkdir();
		System.out.println("Folder created");
		
		//creating a new file in created folder
		File f1 = new File(f,"file_handling.txt");
		f1.createNewFile();
		
		FileWriter fw = new FileWriter(f1);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		
//		pw.println(100); //integer
//		pw.println(10.5); //double
//		pw.println(8920097641l); //long
//		pw.println(10.6f);	//float
		pw.write(100); //it store the ASCII value
		bw.newLine(); //newLine(); method is only in BufferWriter
		pw.println("hello");	//String
		pw.println('A');	//Character
//		pw.println(true);	//boolean
//		pw.println(false);	//boolean
		
		pw.flush();
		pw.close();
		
		FileReader fr = new FileReader(f1);
		BufferedReader br = new BufferedReader(fr);
		
		String readline = br.readLine();
		
		while(readline!=null) {
			System.out.println(readline);
			readline = br.readLine();
		}
		br.close();		
	}
}