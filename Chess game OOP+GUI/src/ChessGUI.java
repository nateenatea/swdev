import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import static javax.swing.SwingUtilities.*;

public class ChessGUI {
	private JFrame frame;
	private static ChessBoard board;
	private static BoardPanel boardPanel;
	private ChessPiece movedPiece = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {		
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
		board = new ChessBoard();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNewGame = new JMenuItem("New Game");
//		mnFile.add(mntmNewGame);
		
		mntmNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		mnFile.add(mntmNewGame);
		
		boardPanel = new BoardPanel();
		frame.getContentPane().add(boardPanel);
		
	}
	
	public void reset() {
		board = new ChessBoard();
		boardPanel.updateBoard();
	}
	
	private class BoardPanel extends JPanel {
		final List<TilePanel> boardTiles;
		
		BoardPanel(){
			super(new GridLayout(8, 8));
			this.boardTiles = new ArrayList<TilePanel>();
			for(int i = 0; i < 64; i++)
			{
				final TilePanel tile = new TilePanel(i);
				this.boardTiles.add(tile);
				add(tile);
			}
			
			setPreferredSize(new Dimension(400, 350));
		}
		
		void updateBoard() {
            removeAll();
            boardTiles.clear();
            // Redraw all tiles
            for(int i = 0; i < 64; i++)
			{
				final TilePanel tile = new TilePanel(i);
				this.boardTiles.add(tile);
				add(tile);
			}
            validate();
            repaint();
        }
	}
	
	private class TilePanel extends JPanel {
		private final int tileId;
		
		TilePanel(final int tileId){
			super(new GridBagLayout());
			
			// Set tile colors
			this.tileId = tileId;
			if ((tileId+tileId / 8) % 2 == 0)
				setBackground(Color.decode("#EAEAEA"));
			else 
				setBackground(Color.decode("#7D7D7D"));
			
			
			// Set tile icons
			int row = tileId / 8;
			int col = tileId % 8;
			
			if(board.pieceAt(row, col) != null) {
				String iconFileName = board.pieceAt(row, col).getIconFileName();
				try {
					final BufferedImage image = ImageIO.read(new File("icons/" + iconFileName));
					add(new JLabel(new ImageIcon(image)));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			// Add mouse listener
           addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(final MouseEvent event) {
                	
                	if(movedPiece == null) {
                		movedPiece = board.pieceAt(row, col);
                	}
                	else {	
                		// already clicked on a non-empty tile before         		
                		board.movePiece(movedPiece.row, movedPiece.col, row, col);
                		movedPiece = null;
                		invokeLater(new Runnable() {
                            public void run() {
                                boardPanel.updateBoard();
                            }
                        });
                	} 
                }

                @Override
                public void mouseExited(final MouseEvent e) {
                }

                @Override
                public void mouseEntered(final MouseEvent e) {
                }

                @Override
                public void mouseReleased(final MouseEvent e) {
                }

                @Override
                public void mousePressed(final MouseEvent e) {
                }
            });
	            
			setPreferredSize(new Dimension(10,10));
		}		
	}

}
