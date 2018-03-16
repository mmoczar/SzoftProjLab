
public class Switch extends Tile {

	private TrapDoor hole;
	
	public Switch() {
	
	}
	
	public Switch( TrapDoor trap) {
	
		hole = trap;
	}
	
	public void setNeighbor(Tile up, Tile down, Tile left, Tile right) {
		UP = up;
		DOWN = down;
		LEFT = left;
		RIGHT = right;
	}

	public void Hi() {
		System.out.print("S");
	}
}
