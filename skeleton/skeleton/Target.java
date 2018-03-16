import java.util.ArrayList;

public class Target extends Tile {
	
	private ArrayList<Box> boxes = new ArrayList<Box>();
	
	
	public Target() {
		
	}

	public void AddBox(Box b) {
		boxes.add(b);
	}
	
	public void Accept(Entity e, Direction d) {
		
	} 
	
	public void setNeighbor(Tile up, Tile down, Tile left, Tile right) {
		UP = up;
		DOWN = down;
		LEFT = left;
		RIGHT = right;
	}
	
	public void Hi() {
		System.out.print("D");
	}
}
