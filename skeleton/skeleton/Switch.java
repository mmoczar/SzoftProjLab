
public class Switch extends Tile {

	private TrapDoor hole;
	
	public Switch() {
	
	}
	
	public Switch( TrapDoor trap) {
	
		hole = trap;
	}
	
	public void setNeighbor(Tile up, Tile down, Tile left, Tile right) {
		tUP = up;
		tDOWN = down;
		tLEFT = left;
		tRIGHT = right;
	}

	public void Hi() {
		System.out.print("S");
	}
}
