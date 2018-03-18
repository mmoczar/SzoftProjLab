import java.io.IOException;
import java.util.ArrayList;

public class Target extends Tile {
	
	private ArrayList<Entity> boxes = new ArrayList<Entity>();
	private WareHouse wh;
	
	
	public Target() throws IOException {
		Szkeleton.kiir(">", "Target", "Target()");	
		Szkeleton.kiir("<", "Target", "Target()");
	}

	public void AddBox(Box b) {
		boxes.add(b);
	}
	
	public void Accept(Entity e, Direction d) throws IOException {
		Szkeleton.kiir(">", "Target", "Accept()");
		if (boxes.contains(e)) {
			e.reduceNum();
		}
		Szkeleton.kiir("<", "Target", "Accept()");
	}
	
	public void setNeighbor(Tile up, Tile down, Tile left, Tile right) {
		tUP = up;
		tDOWN = down;
		tLEFT = left;
		tRIGHT = right;
	}
	
	public void Hi() {
		System.out.print("D");
	}
}
