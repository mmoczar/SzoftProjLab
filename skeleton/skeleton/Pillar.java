
public class Pillar extends Tile {
	
	
	public Pillar() {
		
	}

	public void Accept(Entity e, Direction d) {
		
	}
	
	public void setNeighbor(Tile up, Tile down, Tile left, Tile right) {
		UP = up;
		DOWN = down;
		LEFT = left;
		RIGHT = right;
	}
	
	//Debug f�ggv�ny
	public void Hi() {
		System.out.print("X");
	}
}
