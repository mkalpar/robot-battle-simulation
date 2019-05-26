package dev.ryastark.simulation;
import dev.ryastark.simulation.Display;
import dev.ryastark.simulation.characters.Robot;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.Math;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Battle implements Runnable {
	
	private Display display;	
	public int width, height;
	public String title;
	public Robot R1;
	public Robot R2;
	public int distance;
	
	public Graphics g;
	public int lineX1 = 20;
	public int lineX2 = 904;
	
	private BufferStrategy bs;
	
	private BufferedImage r2Image;
	private BufferedImage r1Image;
	private BufferedImage a2Image;
	private BufferedImage a1Image;
	
	
	private Thread thread;
	private boolean running = false;
	
	
	public Battle(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;		
		R1 = new Robot(8, 1, 1, 0, "/robot-to-right.png");
		R2 = new Robot( 3, 5, 2, 19, "/robot-to-left.png");
	}
	
	private void init() {
		
		display = new Display(title, width, height);			
	}
	public void run() {
		
		init();
		while(running) {
			tick();
			render();
			battleOfRobots(R1, R2); 
		}
		
		stop();
	}
	
	public int calculateDamage(Robot r1, Robot r2) {

		double randomDouble = Math.random();
		randomDouble = randomDouble * 10 + 1;
		int randomInt = (int) randomDouble;
		
		int damageOnRobot2 = randomInt * r1.attackValue / distance - r2.defenseValue * (distance/10);
		System.out.println("Rand value : " + randomInt + " and damage: " + damageOnRobot2);
		if (damageOnRobot2 < 0)
			return 0;
		else return damageOnRobot2;
		
	}
		
	
	public void battleOfRobots(Robot r1, Robot r2) {
		
		int whoseTurn = 1;
		do{			
			System.out.println("Round " + whoseTurn);
			distance = Math.abs(r2.locationCoords - r1.locationCoords);
			System.out.println("Distance between robots: " + distance);
		    //System.out.println(r1 + " begins the fight against " + r2);		    
		    int choice = (int)(Math.random() * 2) + 1;		    
		    System.out.println("Robot " + r1 + "'s choice: " + choice);		    
		    if (choice == 1) {
		    	System.out.println("Move!");
		    	int energyConsumed = (distance/r1.speedValue) * 5;
		    	System.out.println("Enery consumed by moving : " + energyConsumed);
		    	r1.setEnergyValue(r1.energyValue - energyConsumed);
		    	System.out.println("New energy value of robot after moving: " + r1.energyValue);
		    	if(whoseTurn % 2 == 0) {
		    		r1.setLocationCoords(r1.locationCoords - r1.speedValue);
		    	}
		    	else if (whoseTurn % 2 == 1) {
			    	r1.setLocationCoords(r1.locationCoords + r1.speedValue);
		    	}
		    	System.out.println("New location: L = " + r1.locationCoords);
		    }
		    else if (choice == 2) {
		    	System.out.println("Fire missile!");
			    int damage = calculateDamage(r1, r2);
			    System.out.println("Damage occured on the other Robot : " + damage);
			    r2.setEnergyValue(r2.energyValue - damage);
			    System.out.println("New energy value of robot after being attacked: " + r2.energyValue);
			    
		    }
		    
		    // Swap parameters for rounds
		    Robot temp = r1;
		    r1 = r2 ;
		    r2 = temp;
		    
		    whoseTurn++;
		    System.out.println("--------------------------------------------------------");
		  }while(r1.energyValue >= 1 && r2.energyValue >= 1);
		
		System.out.println("Battle over in " + whoseTurn + " rounds.");
		  if(r1.energyValue < 1)
		    System.out.println(r1 +" has lost the fight");
		  else
		    System.out.println(r2 +" has lost the fight");
	}


	
	private void tick(){

	}
	private void render(){
		
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(2);
			return;
		}
		
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		// Draw here 

		int lineY1 = height-50;
		int lineY2= height-140;
		g.drawLine(lineX1, lineY1, width-20, height-50);
		//g.drawRect(lineX1, lineY2, 50, 50);
		//g.drawRect(lineX2, lineY2, 50, 50);
		
		
		try {
			r2Image = ImageIO.read(new File("/robot-to-left.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		
		g.drawImage(r2Image, lineX2, lineY2, null);		
		
		// End drawing
 		
		bs.show();
		g.dispose();
	}

	
	
	
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();

		
	}
	
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
