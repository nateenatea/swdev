
public class Coordinate {
	int row,col;
	
	public Coordinate(String alg) {
		char first,second;
		
		first = alg.charAt(0);
		second = alg.charAt(1);
		
		col = first - 'a';
		row = '8' - second;
		
	}
}
