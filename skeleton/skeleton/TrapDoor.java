import java.io.IOException;


// A kapcsolóval aktivált lyukakat reprezentálja
public class TrapDoor extends Tile {
	
	// alapbol zarva
	private boolean state = false;
	//protected Switch Switch;

	// Default konstruktor
	public TrapDoor() throws IOException {

	}

	// Csapóajtó állapotának lekérdése
	public boolean GetState() throws IOException {

		return state;
	}

	// Csapóajtó állapotának átváltása
	public void SetState() {
		state = !state;
	}
	
	// Debug fn
	public void Hi() {
		System.out.print("T");
	}
	
	// eloszor ralep az entitas, es ha nyitva van, akkor leejti
	public boolean Accept(Entity e, Direction d) throws IOException {
		super.Accept(e, d);
		if(state) DropEntity(e); // ha nyitva, leejti
		return true;
	}

	// A mezőn lévő enity leejtése
	public void DropEntity(Entity e) throws IOException {

	}
	
}
