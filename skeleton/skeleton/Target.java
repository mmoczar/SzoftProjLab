import java.io.IOException;
import java.util.ArrayList;

/**
 * A dobozok céljait reprezentáló osztály, ha olyan doboz érkezik rá, ami hozzá van rendelve,
 * akkor elnyeli azt
 */
public class Target extends Tile {

	// A célhez rendelt dobozok tárolója
	private ArrayList<Entity> boxes = new ArrayList<Entity>();

	private WareHouse wh;
	
	// Default konstruktor
	public Target() throws IOException {

	}

	// Doboz hozzárendelése a célhoz
	public void AddBox(Box b) {
		boxes.add(b);
	}

	// A célra érkező entity-ket kezeli
	public void Accept(Entity e, Direction d) throws IOException {

	}

	// Debug fv
	public void Hi() {
		System.out.print("D");
	}
}
