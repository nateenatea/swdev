
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
	
	public String getIconFileName(){
		if(this.color == 1) {
			if(getType() == PieceType.KING) {
				return "BK.png";
			}
			if(getType() == PieceType.KNIGHT) {
				return "BN.png";
			}
			if(getType() == PieceType.PAWN) {
				return "BP.png";
			}
			if(getType() == PieceType.ROOK) {
				return "BR.png";
			}
			if(getType() == PieceType.BISHOP) {
				return "BB.png";
			}
			if(getType() == PieceType.QUEEN) {
				return "BQ.png";
			}
		}
		else {
			if(getType() == PieceType.KING) {
				return "WK.png";
			}
			if(getType() == PieceType.KNIGHT) {
				return "WN.png";
			}
			if(getType() == PieceType.PAWN) {
				return "WP.png";
			}
			if(getType() == PieceType.ROOK) {
				return "WR.png";
			}
			if(getType() == PieceType.BISHOP) {
				return "WB.png";
			}
			if(getType() == PieceType.QUEEN) {
				return "WQ.png";
			}
		}
		return null;
	}
}
