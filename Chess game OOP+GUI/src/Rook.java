
public class Rook extends ChessPiece {


	
	public Rook(int row, int col,int color) {
		super(row, col, color);
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
		
		if(this.row-row == 0 ) {
			
			if(this.col - col <= 0) {
				for(int i = this.col+1 ; i >= col ; i++) {
					if(board.pieceAt(row, i)!=null )
						return false;
				}	
			}
			
			
			if(this.col - col >= 0) {
				for(int i = this.col-1 ; i <= col ; i--) {
					if(board.pieceAt(row, i)!=null )
						return false;
				}	
				
			}
			
			return true;
		}
		
		
		if(this.col-col == 0) {		
			
			if(this.row - row >= 0) {
				for(int i = this.row-1 ; i >= row ; i--) {
					if(board.pieceAt(i, col) !=null )
						return false;
				}	
			}
			
			
			if(this.row - row <= 0) {
				for(int i = this.row+1 ; i <= row ; i++) {
					if(board.pieceAt(i, col )!=null )
						return false;
				}	
			}
			
			
			return true;
		}
		
		
		
		
		return false;
	}
}
