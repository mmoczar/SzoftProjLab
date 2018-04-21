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
	public boolean Accept(Entity e, Direction d, Worker w) throws IOException {
		if(e.getTarget() == this) {
			e.SetTile(this);
			System.out.println("Sikeres Accept");
			System.out.println("Sikeres Target");
			w.AddPlacedBox();
			return true;
		}
		else
			return super.Accept(e, d, w);
	}

	// Debug fv
	public void Hi() {
		System.out.print("D");
	}
}
