
public class Pawn extends ChessPiece {


	
	public Pawn(int row, int col,int color) {
		super(row, col,color);
	}

	@Override
	void printPiece() {
		if(color == 1) {
			System.out.print("p ");
		}
		else {
			System.out.print("P ");
		}
	}

	@Override
	PieceType getType() {
		
		return PieceType.PAWN;
	}

	@Override
	boolean isValidMove(ChessBoard board, int row, int col) {
		if(this.row-1 == row) {
			return true;
		}
		return false;
	}
	
}
