import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import javax.swing.JFrame;
import java.util.Random;
public class Window extends JFrame{

	private static final long serialVersionUID = 1L;

	private ArrayList<Particle> particles = new ArrayList<Particle>();
	private int mouseX = 0;							// mouse x position
	private int mouseY = 0;							// mouse y position
	private BufferStrategy bufstrat = null;
	private Canvas render;
//	private Color color;

	
	private static final int numParticles = 12;		// total number of particles


	public static void main(String[] args) {
		Window window = new Window(1024, 768, "Particle Simulator 2018");
		window.pollInput();
	    window.loop();
	}

	public boolean Updown() {
		Random rdm = new Random();
		int r = rdm.nextInt()%2;
		if(r == 1) {
			return true;
		}
		else{
			return false;
		}
	}
	
	
	
	
	public void pollInput()
	{
		render.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {

				for(int i=0; i < numParticles; i++) {
					Color color = new Color((int)(Math.random() * 0x1000000));
					Particle proton = new Trion("Proton", mouseX , mouseY, color , Updown());
					particles.add(proton);
					Particle proton2 = new Squaron("Proton", mouseX , mouseY, color , Updown());
					particles.add(proton2);
					Particle proton3 = new BrownianParticle("Proton", mouseX , mouseY, color , Updown());
					particles.add(proton3);
					Particle proton4 = new AccelParticle("Proton", mouseX , mouseY, color , Updown());
					particles.add(proton4);
				}
				
			}

			public void mouseEntered(MouseEvent e) {
				
			}

			public void mouseExited(MouseEvent e) {

			}

			public void mousePressed(MouseEvent e) {

			}

			public void mouseReleased(MouseEvent e) {
				
			}
			
		
		});
	}
	

	public Window(int width, int height, String title) 
	{
		super();
		setTitle(title);
		setIgnoreRepaint(true);
		setResizable(false);

		render = new Canvas();
		render.setIgnoreRepaint(true);
		int nHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int nWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();

		nHeight /= 2;
		nWidth /= 2;

		setBounds(0, 0, width, height);
	    render.setBounds(nWidth-(width/2), nHeight-(height/2), width, height);

	    add(render);
	    pack();
	    setVisible(true);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    render.createBufferStrategy(2);
	    bufstrat = render.getBufferStrategy();
	}

	public void loop()
	{
		while(true)
		{
			update();
			render();

			try {
				Thread.sleep(1000/60);			// 60 Hz frame rate
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	

	public void update()
	{
		Point p = render.getMousePosition();
		if(p != null)
		{
			mouseX = p.x;
			mouseY = p.y;
		}
		for(int i=0; i < particles.size(); i++)
			if(particles.get(i).update())
				particles.remove(i);
	}

	
	
	public void render()
	{
		do{
			do{
				Graphics2D g2d = (Graphics2D) bufstrat.getDrawGraphics();
				g2d.fillRect(0,0, render.getWidth(), render.getHeight());
		
				renderParticles(g2d);
				g2d.dispose();

			}while(bufstrat.contentsRestored());
			bufstrat.show();

			
		}while(bufstrat.contentsLost());
	}

	public void renderParticles(Graphics2D g2d)
	{
		for(int i=0; i < particles.size(); i++)
			particles.get(i).render(g2d);
		
		// TODO: remove drawing test
	//	g2d.setColor(Color.WHITE);
	//	g2d.fillOval(400-30, 300-30, 60, 60);		// Drawing test
		
		g2d.dispose();
	 
	} 


}

/* 2018 revision */