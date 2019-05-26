package dev.ryastark.simulation;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Display {

	private JFrame frame;
	private Canvas canvas;
	
	private String title;
	private int width, height;
	
	public JLabel robotR;
	public JLabel robotL;
	
	
	public Display(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		
		frame = new JFrame(title);
		frame.setSize(width,height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new FlowLayout());
		
		
		ImageIcon iconR = new ImageIcon("/robot-to-right.png");
		ImageIcon iconL = new ImageIcon("/robot-to-left.png");

		robotR = new JLabel(iconR);
		robotL = new JLabel(iconL);		
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		
		frame.add(robotR);
		frame.add(robotL);
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	
}
