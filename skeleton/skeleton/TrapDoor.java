import java.io.IOException;

public class TrapDoor extends Tile {
	
	// alapbol zarva
	private boolean state = false;
	//protected Switch Switch;

	public TrapDoor() throws IOException {
		Szkeleton.kiir(">", "TrapDoor", "TrapDoor()");	
		Szkeleton.kiir("<", "TrapDoor", "TrapDoor()");
	}
	
	public boolean GetState() {
		return state;
	}
	
	public void SetState(boolean s) {
		state = s;
	}
	
	public void setNeighbor(Tile up, Tile down, Tile left, Tile right) {
		tUP = up;
		tDOWN = down;
		tLEFT = left;
		tRIGHT = right;
	}
	
	public void Hi() {
		System.out.print("T");
	}
}
