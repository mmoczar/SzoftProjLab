
public class Pillar extends Tile {
	
	
	public Pillar() {
		
	}

	//oszlop acceptje
	public boolean Accept(Entity e) {
		System.out.println("Ez egy oszlop");
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
	
	//Debug f�ggv�ny
	public void Hi() {
		System.out.print("X");
	}
}
