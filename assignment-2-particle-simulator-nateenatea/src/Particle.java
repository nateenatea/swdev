import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Particle {
	
	private static final int avgSpeed = 5;			// average speed in pixels/frame
	private static final int avgSize = 30;			// average size in pixels
	private static final int avgLife = 50;			// average life in milliseconds
	
	public int x;
	public int y;
	public int dx;
	public int dy;
	public int size;
	public int life;
	public Color color;	
	public String name;
	
	public Particle(String name, int x, int y, Color color, boolean isUpward)
	{
		// TODO: your constructor code goes here
		this.x = x;
		this.y = y;
		this.color = color;
		
		// randomize size, life, and velocity of the particle
		size = (int) (avgSize + (1 - 2*Math.random()) * avgSize / 2);
		life = (int) (avgLife + (1 - 2*Math.random()) * avgLife / 2);
		
		int magnitude = (int) (avgSpeed + (1 - 2*Math.random()) * avgSpeed / 2);
		double angle;
		if(isUpward)
			angle = (2 - Math.random()) * Math.PI;
		else 
			angle = Math.PI * Math.random();	
		dx = (int) (magnitude * Math.cos(angle));
		dy = (int) (magnitude * Math.sin(angle));
	}
	
	// Update particle's position and life
	// Return true if the particle is dead (life == 0)
	public boolean update()
	{ 
		// increment particle's position by delta 
		x += dx;
		y += dy;
		
		// TODO:
		// check for collision and bounce off the wall
		if((x <= 0 && dx <= 0) || x+dx <= 0 ) {
			x = 0 ;
			dx = -dx;
			x += dx ;	
		}
		else if((y <= 0 && dy <= 0) || y+dy <= 0 ) {
			y = 0 ;
			dy = -dy;
			y += dy ;
			
		}
		else if((x >= 1024 && dx >= 0) || x+dx >= 1024 ) {
			x = 1024 ;
			dx = -dx;
			x += dx ;
		}
		else if((y >= 768 && dy >= 0) || y+dy >= 768  ) {
			y = 768 ;
			dy = -dy;
			y += dy ;
		}
		else {
			x += dx;
			y += dy;
		}
		
		// TODO:
		// update particle's remaining life
		life--;
		
		// TODO: 
		// check if life is negative (particle is dead). if so, return true	
		if(life<=0) {
			return true;
		}

		return false;
	}
	
	// Draw particle on the screen
	public void render(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g.create();
		
		g2d.setColor(color);
		g2d.fillOval(x, y,size,size);

		// TODO: display particle's info next to the particle object
		
		
		g2d.dispose();
	}
	
	
	public String toString()
	{
		return "Particle " + name + " at (" + x + ", " + y + ")";
	}

}

/* 2017 revision */