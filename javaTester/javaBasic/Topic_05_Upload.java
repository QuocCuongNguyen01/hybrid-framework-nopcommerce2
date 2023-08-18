package javaBasic;

import java.io.File;

public class Topic_05_Upload {
	
	static String[] fileNames = {"Indonesia.jpeg","ThaiLan.jpeg", "VietNam.jpeg"};
	
	static String fullFileName = "";

	public static void main(String[] args) {
		String filePath = System.getProperty("user.dir") + File.separator + "UploadFile" + File.separator;
		System.out.println(filePath);
		for (String file : fileNames) {
			System.out.println(file);
			fullFileName = fullFileName + filePath + file + "\n";
			System.out.println(fullFileName);

			
		}
		fullFileName = fullFileName.trim();
	}
}
