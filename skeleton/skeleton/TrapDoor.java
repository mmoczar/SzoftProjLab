import java.io.IOException;

public class TrapDoor extends Tile {
	
	// alapbol zarva
	private boolean state = false;
	//protected Switch Switch;

	public TrapDoor() throws IOException {
		Szkeleton.kiir(">", "TrapDoor", "TrapDoor()");	
		Szkeleton.kiir("<", "TrapDoor", "TrapDoor()");
	}
	
	public boolean GetState() throws IOException {
		Szkeleton.kiir(">", "TrapDoor", "GetState()");
		Szkeleton.kiir("<", "TrapDoor", "GetState(): "+ state);
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
	
	// eloszor ralep az entitas, es ha nyitva van, akkor leejti
	public void Accept(Entity e, Direction d) throws IOException {
		super.Accept(e, d);
		if(!state) DropEntity(e); // TODO Nem a true a nyitott allapot??? (bence)
	}
	
	public void DropEntity(Entity e) throws IOException {
		Szkeleton.kiir(">", "TrapDoor", "DropEntity(e)");
		Remove(e);
		Szkeleton.kiir("<", "TrapDoor", "DropEntity(e)");
	}
	
}
