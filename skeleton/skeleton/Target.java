import java.util.ArrayList;

public class Target extends Tile {
	
	private ArrayList<Box> boxes = new ArrayList<Box>();
	
	
	public Target(Vec2D pos) {
		super(pos);
		// TODO Auto-generated constructor stub
	}

	public void AddBox(Box b) {
		boxes.add(b);
	}
	
	public void Accept(Entity e, Direction d) {
		
	} 
	
	public void Hi() {
		System.out.print("D");
	}
}
