import java.io.IOException;

public class Worker extends Entity {

	
	private int numOfPlacedBoxes;
	

	public Worker() {
	}

	public void SetTile(Tile t) {
		//Tile beallotsa
		tile = t;
	}
	
	//Worker mozgatasa
	@Override
	public boolean Move(Entity e, Direction d) throws IOException {
			//Ellenorzi hogy az adott iranyban van-e valaki
			
			Szkeleton.kiir(">", "Worker", "Move()");
			
			Tile tile = new Tile();
			Entity nb = tile.GetEntityAt(Direction.UP);
			
			if(nb == null) {
				tile.Accept(this, d);
			}
			
			
			Szkeleton.kiir("<", "Worker", "Move()");
			
			return false;
				
		}
	

	@Override
	public boolean SwitchAction() {
		return true;
	}

	@Override
	public boolean MovedBy(Entity e) {
		
		if(e == null) return false;
		
		return true;
		
	}
	
	public void Die() {
		
	}
	
	public void AddPlacedBox() {
		numOfPlacedBoxes++;
	}
	
	
	public void Hi() {
		System.out.print("W");
	}

	@Override
	public void reduceNum() {
		Game.getCurrentWH().reduceNumOfWorkers();
		
	}
}
