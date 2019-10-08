
public class Queen extends ChessPiece {


	
	public Queen(int row, int col,int color) {
		super(row, col,color);
	}

	@Override
	void printPiece() {
		if(color == 1) {
			System.out.print("q ");
		}
		else {
			System.out.print("Q ");
		}
	}

	@Override
	PieceType getType() {
		
		return PieceType.QUEEN;
	}

	@Override
	boolean isValidMove(ChessBoard board, int row, int col) {
		
		if(this.row-row == 0 ) {
			return true;
		}
		if(this.col-col == 0) {
			return true;
		}
		for(int i = 0 ; i < 8 ; i++) {
			if((this.row-i)==row && (this.col + i ) == col)
				return true;
			if((this.row+i)==row && (this.col - i ) == col)
				return true;
			if((this.row-i)==row && (this.col - i ) == col)
				return true;
			if((this.row+i)==row && (this.col + i ) == col)
				return true;
		}
		
		return false;
	}
	
}
