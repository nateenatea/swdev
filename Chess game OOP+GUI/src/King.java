
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
		
		return false;
	}
	
}
