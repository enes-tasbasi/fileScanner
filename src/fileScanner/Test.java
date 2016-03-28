package fileScanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Test {
	
		   public static void main(String[] args) {
			   		

			  JFrame frame = new JFrame("Demo");
			  frame.setVisible(true);
			  frame.setSize(400, 400);
			  frame.setLocation(540, 200);
			  frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
			  
			  JPanel panel = new JPanel();
			  frame.add(panel);
			  
			  JTextArea ta = new JTextArea(5, 20);
			  ta.setEditable(false);
			  panel.add(ta);
			  
			  ta.append("Hello world from java");
			   
			   
		}
}
	


