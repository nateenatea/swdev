
public class Knight extends ChessPiece {


	
	public Knight(int row, int col,int color) {
		super(row, col,color);
	}

	@Override
	void printPiece() {
		if(color == 1) {
			System.out.print("n ");
		}
		else {
			System.out.print("N ");
		}
	}

	@Override
	PieceType getType() {
		
		return PieceType.KNIGHT;
	}

	@Override
	boolean isValidMove(ChessBoard board, int row, int col) {
		
		if((this.col + 2) == col && (this.row - 1  ) == row )
			return true ;
		if((this.col - 2) == col && (this.row + 1  ) == row )
			return true ;
		if((this.col - 2) == col && (this.row - 1  ) == row )
			return true ;
		if((this.col + 2) == col && (this.row + 1  ) == row )
			return true ;
		if((this.col + 1) == col && (this.row - 2  ) == row )
			return true ;
		if((this.col - 1) == col && (this.row + 2  ) == row )
			return true ;
		if((this.col - 1) == col && (this.row - 2  ) == row )
			return true ;
		if((this.col + 1) == col && (this.row + 2  ) == row )
			return true ;
		
		return false;
	}
	
}
