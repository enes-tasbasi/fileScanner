package fileScanner;

import java.io.*;
import java.util.*;



public class Test {
	
		   public static void main(String[] args) {
			   BufferedReader br = null;
			   String[] word;
		    	File file = new File("example.txt");
		    	
		    	try {
		    		
					FileReader fr = new FileReader(file);
					
					br = new BufferedReader(fr);
					String line;
					while((line = br.readLine()) != null) {
						word = line.split(" ");
						int count = 0;
						for(int i = 0; i < word.length; i++) {
							if(word[i].equals("enes")) {
								count++;
								
							}
						}	
						System.out.println(count);
					}
				} catch (FileNotFoundException e) {
					System.out.println("Cannot find the file.");
				} catch (IOException e) {
					System.out.println("A problem occurred");
				} finally {
					try {
						br.close();
					} catch(IOException ex) {
						System.out.println("Cannot close");
					}
				}
		    	
		}
}
	


