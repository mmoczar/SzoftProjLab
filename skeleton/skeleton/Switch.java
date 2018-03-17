import java.io.IOException;

public class Switch extends Tile {

	private TrapDoor hole;
	
	public Switch() throws IOException {
		Szkeleton.kiir(">", "Switch", "Switch()");	
		Szkeleton.kiir("<", "Switch", "Switch()");	
	}
	
	public Switch( TrapDoor trap) throws IOException {
		Szkeleton.kiir(">", "Switch", "Switch(trap)");	
		Szkeleton.kiir("<", "Switch", "Switch(trap)");
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
