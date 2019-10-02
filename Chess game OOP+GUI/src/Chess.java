public class Chess {
	public ChessBoard board;
	
	public static void main(String[] args) {
		ChessBoard board = new ChessBoard();
		board.printboard();
		
		Player move = new Player();
		move.move();
	}
}
