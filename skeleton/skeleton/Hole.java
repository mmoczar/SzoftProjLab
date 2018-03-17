import java.io.IOException;

public class Hole extends Tile {

	public Hole() throws IOException {
		Szkeleton.kiir(">", "Hole", "Hole()");
		Szkeleton.kiir("<", "Hole", "Hole()");
	}
	
	public boolean Accept(Entity e) throws IOException {
		Szkeleton.kiir(">", "Hole", "Accept(e)");
		System.out.println(" leesett!");
		Szkeleton.kiir("<", "Hole", "Accept(e)");
		return false;
		
	}
	
	public void setNeighbor(Tile up, Tile down, Tile left, Tile right) {
		tUP = up;
		tDOWN = down;
		tLEFT = left;
		tRIGHT = right;
	}
	
	public void Hi() {
		System.out.print("H");
	}
}
