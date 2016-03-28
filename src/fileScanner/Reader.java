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
	private File file;
	
	
	public Reader() {
		
		setLayout(new BorderLayout());
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		add(panel1, BorderLayout.NORTH);
		
		JLabel lb1 = new JLabel("Enter the text/phrase: ");
		panel1.add(lb1);
		
		tf = new JTextField("", 10);
		panel1.add(tf);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1, 4));
		add(panel2, BorderLayout.SOUTH);
		
		JButton choose = new JButton("Choose File");
		choose.addActionListener(new Listener3());
		panel2.add(choose);
		
		panel2.add(new JLabel(""));
	//	panel2.add(new JLabel(""));
	//	panel2.add(new JLabel(""));
		
		JButton find = new JButton("Find");
		find.addActionListener(new Listener1());;
		panel2.add(find);
		
		JButton clear = new JButton("Clear");
		clear.addActionListener(new Listener2());
		panel2.add(clear);

		
	}
	
	public class Listener1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			String[] word;
			BufferedReader br = null;
			
	    	//File file = new File("example.txt");
	    		
	    	try {
	    		
				FileReader fr = new FileReader(file);
				br = new BufferedReader(fr);
				
				final TextCleaner tc = new TextCleaner();
				String line;
				while((line = br.readLine()) != null) {
					line = tc.clean(line);
					word = line.split(" ");
					int count = 0;
					for(int i = 0; i < word.length; i++) {
						if(word[i].equals(tf.getText())) {
							count++;
							
						}
					}
					label.setText("There are " + count + " occurance(s) of the word " + 
					tf.getText());
				}
	    	} catch (IOException e1) {
	    	    System.out.println("A problem occurred.");
	    	}
	    	
	    	try {
				br.close();
			} catch (IOException e1) {
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
	
	public class Listener3 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			final JFileChooser fc = new JFileChooser();
			
			int returnVal = fc.showOpenDialog(fc);
			
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				file = fc.getSelectedFile();
			}
		}
	}
}
