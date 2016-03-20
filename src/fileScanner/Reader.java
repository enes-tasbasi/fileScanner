package fileScanner;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.print.DocFlavor.URL;
import javax.swing.*;

public class Reader extends JPanel{
	
	private JTextField tf;
	private Scanner in;
	private String word;
	private StringTokenizer st;
	private JLabel label;
	
	public String replace(String str, int index, char replace){     
	    if(str==null){
	        return str;
	    }else if(index<0 || index>=str.length()){
	        return str;
	    }
	    char[] chars = str.toCharArray();
	    chars[index] = replace;
	    return String.valueOf(chars);       
	}
	
	public Reader() {
		setLayout(new FlowLayout());
		
		JLabel lbl = new JLabel("Enter the text/phrase: ");
		add(lbl);
		
		tf = new JTextField("", 10);
		add(tf);
		
		JButton find = new JButton("Find");
		find.addActionListener(new Listener1());
		add(find);
		
		JButton clear = new JButton("Clear");
		clear.addActionListener(new Listener2());
		add(clear);
		
		label = new JLabel("");
		add(label);
		
	}
	
	public class Listener1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			String[] word;
			BufferedReader br = null;
			
	    	File file = new File("example.txt");
	    		
	    	try {
	    		
				FileReader fr = new FileReader(file);
				br = new BufferedReader(fr);
				
				
				
//				for(int i = 0; i < line.length(); i++) {
//					index[i] = word[i].indexOf(",");
//					System.out.println(index[i]);
//				}
				String line;
				while((line = br.readLine()) != null) {
					word = line.split(" ");
					int count = 0;
					for(int i = 0; i < word.length; i++) {
						if(word[i].equals(tf.getText())) {
							count++;
							
						}
					}
					label.setText("There are " + count + " occurance(s) of the word " + 
					tf.getText() + " in " + file.toString());
				}
	    	} catch (IOException e1) {
	    	    System.out.println("A problem occurred.");
	    	}
	    	
	    	try {
				br.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("Cannot close the file");
			}
		}
	}
	
	public class Listener2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			tf.setText("");
			label.setText("");
			
		}
	}
}
