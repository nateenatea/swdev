import java.util.Scanner;

public class Chess {
	public ChessBoard board;
	public int turns;
	public static String players;
	public static String move;
	public String to;
	
	public static void main(String[] args) {
		ChessBoard board = new ChessBoard();
		board.printboard();
		Player player1, player2 = new Player();
		
		while(true) {
//			Scanner position = new Scanner(System.in);
//			System.out.print("Move: ");	
//			move = position.next(); 	
//			
//			Coordinate from = new Coordinate(move.substring(0,2));
//			Coordinate to = new Coordinate(move.substring(2,4));
//			board.movePiece(from,to);
//			board.printboard();
		}
	}
}
