import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

public class ChessGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		ChessBoard board = new ChessBoard();
		board.printboard();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChessGUI window = new ChessGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChessGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new BoardPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		/* JLabel lblGameName = new JLabel("Game Name"); panel.add(lblGameName); */
	}
	
	private class BoardPanel extends JPanel{
		final List<TilePanel> boardTiles;
		BoardPanel(){
			super(new GridLayout(8,8));
			this.boardTiles = new ArrayList<TilePanel>();
			for(int i=0; i<8; i++)
			{
				for(int j=0; j<8; j++)
				{
				final TilePanel tile = new TilePanel(i,j);
				this.boardTiles.add(tile);
				add(tile);
				}
			}
			setPreferredSize(new Dimension(360,350));
		}
	}
	
	private class TilePanel extends JPanel{
		private final int tileIdx;
		private final int tileIdy;
		TilePanel(final int tileIdx,int tileIdy){
			super(new GridBagLayout());
			this.tileIdx = tileIdx;
			this.tileIdy = tileIdy;
			if(tileIdx %2 == 0)
				{
				if(tileIdy %2 == 0)
					setBackground(Color.decode("#FFFACD"));
				else
					setBackground(Color.decode("#593E1A"));
				}			else {
				if(tileIdy %2 == 0)
					setBackground(Color.decode("#593E1A"));
				else
					setBackground(Color.decode("#FFFACD"));
			}	
			setPreferredSize(new Dimension(20,20));
		}
	}

}
