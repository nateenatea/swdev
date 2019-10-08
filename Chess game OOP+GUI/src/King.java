
public class King extends ChessPiece {


	
	public King(int row, int col,int color) {
		super(row, col,color);
	}

	@Override
	void printPiece() {
		if(color == 1) {
			System.out.print("k ");
		}
		else {
			System.out.print("K ");
		}
	}

	@Override
	PieceType getType() {
		
		return PieceType.KING;
	}

	@Override
	boolean isValidMove(ChessBoard board, int row, int col) {
		
		if(this.row-row == 1 || this.row-row == -1 ) {
			return true;
		}
		if(this.col-col == 1 || this.col-col == -1) {
			return true;
		}
		if((this.row-1)==row && (this.col + 1 ) == col)
			return true;
		if((this.row+1)==row && (this.col - 1 ) == col)
			return true;
		if((this.row-1)==row && (this.col - 1 ) == col)
			return true;
		if((this.row+1)==row && (this.col + 1 ) == col)
			return true;
		return false;
	}
	
}
