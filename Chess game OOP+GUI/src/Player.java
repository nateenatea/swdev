import java.util.Scanner;

public class Player {
	public int turns;
	public static String players = "White";
	public String move;
	
	public Player() {
		if(players=="White") {
			players = "Black";
		}
		if(players=="Black") {
			players = "White";
		}
	}
	
	public void move() {
			while(true) {
				Scanner position = new Scanner(System.in);
				System.out.print("Move: ");
				int move = position.nextInt();
				System.out.println("to: ");
				int to = position.nextInt();
				
				if(move == 1 && to == 2 ) {
					ChessBoard board = new ChessBoard();
					board.addPiece(new Pawn(4, 3, 1));
					board.removePiece(new Pawn(6, 3, 1));
					board.printboard();
				}
				if(move == 1 && to == 1 ) {
					ChessBoard board = new ChessBoard();
					board.addPiece(new Pawn(5, 3, 1));
					board.removePiece(new Pawn(6, 3, 1));
					board.printboard();
				}
			}
	}
}
