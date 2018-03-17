
public class Hole extends Tile {

	public Hole() {
	}
	
	public boolean Accept(Entity e) {
		entity = e;
		e = null;
		System.out.println("Entity leesett!");
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
