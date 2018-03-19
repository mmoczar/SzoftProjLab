import java.io.IOException;


/**
 * Az entity-ket elnyelő Tile
 */
public class Hole extends Tile {

	// Default konstruktor
	public Hole() throws IOException {
		Szkeleton.kiir(">", "Hole", "Hole()");
		Szkeleton.kiir("<", "Hole", "Hole()");
	}

	// A Hole-ra érkező entity-ket kezeli
	public boolean Accept(Entity e) throws IOException {
		Szkeleton.kiir(">", "Hole", "Accept(e)");
		System.out.println(" leesett!");
		Szkeleton.kiir("<", "Hole", "Accept(e)");
		return false;
		
	}
	// Debug fv
	public void Hi() {
		System.out.print("H");
	}
}
