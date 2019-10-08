
public class Bishop extends ChessPiece {


	
	public Bishop(int row, int col,int color) {
		super(row, col,color);
	}

	@Override
	void printPiece() {
		if(color == 1) {
			System.out.print("b ");
		}
		else {
			System.out.print("B ");
		}
	}

	@Override
	PieceType getType() {
		
		return PieceType.BISHOP;
	}

	@Override
	boolean isValidMove(ChessBoard board, int row, int col) {
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
