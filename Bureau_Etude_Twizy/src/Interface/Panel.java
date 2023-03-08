package Interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Panel extends JPanel{
	public final static int pixelSize = 48; //changed to 48
	public static int horizontalPixels =16; //changed to 16 + added visibility public+ remove of final
	public static int verticalPixals =12; //changed to 12 + added visibility public + remove of final
	final int screenWidth = pixelSize*horizontalPixels;
	final int screenHeight = pixelSize*verticalPixals+50;
	
	
	public Panel() {
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true); // draw in the background / better performance / not necessary
		//this.addKeyListener(Control);
		this.setFocusable(true);// wait for key 
	}
	
	
	public void run() {
	}
	public void update() {
	}
	public void paintComponent(Graphics g) {
	}
	
	
}
