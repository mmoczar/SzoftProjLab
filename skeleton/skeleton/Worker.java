import java.io.IOException;

public class Worker extends Entity {

	
	private int numOfPlacedBoxes;
	

	public Worker() throws IOException {
		Szkeleton.kiir(">", "Worker", "Worker()");
		Szkeleton.kiir("<", "Worker", "Worker()");
	}

	public void SetTile(Tile t) throws IOException {
		//Tile beallotsa
		Szkeleton.kiir(">", "Worker", "SetTile(t)");
		Szkeleton.kiir("<", "Worker", "SetTile(t)");
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
			
			
			Szkeleton.kiir("<", "Worker", "Move(): false");
			
			return false;
				
	}
	
	// a munkas nem hat a kapcsolora
	@Override
	public boolean SwitchAction() throws IOException {
		Szkeleton.kiir(">", "Worker", "SwitchAction()");
		Szkeleton.kiir("<", "Worker", "SwitchAction(): false");
		return false;
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
