package fileScanner;

import javax.swing.JFrame;

public class Scanner {
	
	public static void main(String[] args)  {
		
		JFrame frame = new JFrame("Scanner");
		frame.setContentPane(new Reader());
		frame.setVisible(true);
		frame.setSize(400, 200);
		frame.setLocation(600, 400);
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		 
	}

}
