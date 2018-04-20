import java.io.IOException;


/**
 * Az entity-ket elnyelő Tile
 */
public class Hole extends Tile {

	// Default konstruktor
	public Hole() throws IOException {

	}

	// A Hole-ra érkező entity-ket kezeli
	public boolean Accept(Entity e) throws IOException {

		return false;
		
	}
	// Debug fv
	public void Hi() {
		System.out.print("H");
	}
}
