
public class Rook extends ChessPiece {


	
	public Rook(int row, int col,int color) {
		super(row, col,color);
	}

	@Override
	void printPiece() {
		if(color == 1) {
			System.out.print("r ");
		}
		else {
			System.out.print("R ");
		}
	}

	@Override
	PieceType getType() {
		
		return PieceType.ROOK;
	}

	@Override
	boolean isValidMove(ChessBoard board, int row, int col) {
		
		return false;
	}
	
}
