import java.io.IOException;

public class Pillar extends Tile {
	
	
	public Pillar() throws IOException {
		Szkeleton.kiir(">", "Pillar", "Pillar()");
		Szkeleton.kiir("<", "Pillar", "Pillar()");
	}

	//oszlop acceptje
	public boolean Accept(Entity e) {
		System.out.println("Ez egy oszlop"); // TODO ezmiez? :D (bence)
		return true;
	}
	
	public void setNeighbor(Tile up, Tile down, Tile left, Tile right) {
		tUP = up;
		tDOWN = down;
		tLEFT = left;
		tRIGHT = right;
	}
	
	public Entity GetEntityAt() {
		return null;
	}
	
	//Debug fuggveny
	public void Hi() {
		System.out.print("X");
	}
}
