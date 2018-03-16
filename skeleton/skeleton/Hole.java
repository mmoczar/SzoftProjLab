
public class Hole extends Tile {

	public Hole() {
	}
	
	public void setNeighbor(Tile up, Tile down, Tile left, Tile right) {
		UP = up;
		DOWN = down;
		LEFT = left;
		RIGHT = right;
	}
	
	public void Hi() {
		System.out.print("H");
	}
}
