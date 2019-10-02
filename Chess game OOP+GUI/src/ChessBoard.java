
public class ChessBoard {
	public ChessPiece[][] board = new ChessPiece[BOARD_SIZE][BOARD_SIZE];
	static final int BOARD_SIZE = 8;
	
	//constructor
	public ChessBoard() {
		// place 32 pieces on board
		addPiece(new  King(0, 3, 0));
		addPiece(new  King(7, 3, 1));
		addPiece(new Queen(0, 4, 0));
		addPiece(new Queen(7, 4, 1));
		addPiece(new Rook(0, 0, 0));
		addPiece(new Rook(0, 7, 0));
		addPiece(new Rook(7, 0, 1));
		addPiece(new Rook(7, 7, 1));
		addPiece(new Bishop(0, 2, 0));
		addPiece(new Bishop(0, 5, 0));
		addPiece(new Bishop(7, 2, 1));
		addPiece(new Bishop(7, 5, 1));
		addPiece(new Knight(0, 1, 0));
		addPiece(new Knight(0, 6, 0));
		addPiece(new Knight(7, 1, 1));
		addPiece(new Knight(7, 6, 1));
		for(int i=0 ; i < 8 ; i++) {
			addPiece(new Pawn(1, i, 0));
			addPiece(new Pawn(6, i, 1));
		}
	}
	
	// board setter
	void addPiece(ChessPiece piece) {
		board[piece.row][piece.col] = piece;
	}
	
	void removePiece(ChessPiece piece) {
		board[piece.row][piece.col] = null;
	}
	
	// board getter
	ChessPiece pieceAt(int row, int col){
		return board[row][col];
	}

	public void printboard() {
		for(ChessPiece[] pieceArray : board) {
			for(ChessPiece piece : pieceArray) {
				if(piece!=null)
					piece.printPiece(); //polymorphism
				else
					System.out.print(". ");
			}
			System.out.println();
		}
	}
}
