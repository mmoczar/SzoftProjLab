import java.util.ArrayList;

public class Target extends Tile {
	
	private ArrayList<Box> boxes = new ArrayList<Box>();
	
	
	public Target() {
		
	}

	public void AddBox(Box b) {
		boxes.add(b);
	}
	
	public void Accept(Entity e, Direction d) {
		// TODO Celba eres megiras
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
