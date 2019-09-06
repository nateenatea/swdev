import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GradientPaint;

public class Trion extends Particle {
	public int ax;
	public int ay;
	
	public Trion(String name,int x,int y,Color color, boolean isUpward) {
		super(name,x,y,color,isUpward);	
		ax = 0;
		ay = 5;
	}
	
	public boolean update() {
		// increment particle's position by delta 
		
				dx += ax;
				dy += ay;
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
	
	public void render(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g.create();
//		g2d.setColor(color);
		
		int d = size/2;
		
		int a[] = {x-d,x,x+d};
		int b[] = {y+d,y-d,y+d};
		int n = 3;
		
		GradientPaint gp = new GradientPaint(75, 75, Color.white,
		        95, 95, color, true);
		g2d.setPaint(gp);
		
		
		g2d.fillPolygon(a,b,n);     // Fills the triangle above.
		getArea(g2d);		
		// TODO: display particle's info next to the particle object
		
		
		g2d.dispose();
	}
	
	public void getArea(Graphics g){
		int d = size/2;
		double area = (size*size)/2;
		Graphics2D g2d = (Graphics2D) g.create();
		String text = String.valueOf(area); 
		g2d.drawString(text,x+d,y+d);
	}
}
