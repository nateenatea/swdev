import java.awt.Color;

public class BrownianParticle extends Particle {
	public int ax;
	public int ay;
	
	public BrownianParticle(String name,int x,int y,Color color, boolean isUpward) {
		super(name,x,y,color,isUpward);
		ax = 0;
		ay = 5;
		
		// TODO: your constructor code goes here
		this.x = x;
		this.y = y;
				
		int magnitude = (int) (randomnumber() + (1 - 2*Math.random()) * randomnumber() / 2);
		double angle;
		if(isUpward)
			angle = (2 - Math.random()) * Math.PI;
		else 
			angle = Math.PI * Math.random();	
		dx = (int) (magnitude * Math.cos(angle));
		dy = (int) (magnitude * Math.sin(angle));
		
	}
	
	public int randomnumber() {
		int range;
		range = 5 + (int) (Math.random() * (11));
		return range;		
	}
	
	public boolean update() {
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
}
