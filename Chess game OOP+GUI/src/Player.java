public class Player {
	public int turns;
	public static String players = "White";
	public String move,to;
	
	public Player() {
		if(players=="White") {
			players = "Black";
		}
		if(players=="Black") {
			players = "White";
		}
	}
}
