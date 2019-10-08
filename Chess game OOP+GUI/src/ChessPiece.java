
abstract public class ChessPiece {
	int row, col;
	int color;
	PieceType type;
	
	public ChessPiece(int row, int col,int color) {
		this.row = row;
		this.col = col;
		this.color = color;
	}
	
	abstract void printPiece();
	abstract PieceType getType();
	abstract boolean isValidMove(ChessBoard board, int row, int col);
	
}
