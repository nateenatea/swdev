
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
		
		return false;
	}
	
}
