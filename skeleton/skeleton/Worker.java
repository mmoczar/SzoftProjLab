import java.io.IOException;


/**
 * A játékos álltal mozgatott Entity
 */
public class Worker extends Entity {

	
	private int numOfPlacedBoxes;
	private Entity byEntity;

	// Default konstruktor
	public Worker() throws IOException {
		Szkeleton.kiir(">", "Worker", "Worker()");
		Szkeleton.kiir("<", "Worker", "Worker()");
	}

	// Tile beállítása
	public void SetTile(Tile t) throws IOException {
		Szkeleton.kiir(">", "Worker", "SetTile(t)");
		Szkeleton.kiir("<", "Worker", "SetTile(t)");
		tile = t;
	}
	
	//Worker mozgatasa
	@Override
	public boolean Move(Entity e, Direction d) throws IOException {
			//Ellenorzi hogy az adott iranyban van-e valaki
			byEntity = e;
			if(d == Direction.UP) {
			Szkeleton.kiir(">", "Worker", "Move()");
			Tile tile = new Tile();
			Entity nb = tile.GetEntityAt(Direction.UP);
		
			if(nb == null) {
				if(tile.Accept(this))
				{
					Szkeleton.kiir("<", "Worker", "Move(): true");
					return true;
				}
				Szkeleton.kiir("<", "Worker", "Move(): false");
				return false;
			}
			else {
				if(nb.MovedBy(e)) {
					if(nb.Move(this, Direction.UP)) {
						Szkeleton.kiir("<", "Worker", "Move(): true");
						return true;
					}
				}
			}
			}
			
			if(d == Direction.DOWN) {
				Tile tile = new Hole();
				tile.Accept(this);
				Szkeleton.kiir("<", "Worker", "Move(): true");
				return true;
			}
			
			if(d == Direction.RIGHT) {
				Tile tile = new Pillar();
				if(e != null) {
					tile.Accept(this);
				}
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
	public boolean MovedBy(Entity e) throws IOException {
		Szkeleton.kiir(">", "Worker", "MovedBy()");
		
		if(e == null) {
			Szkeleton.kiir("<", "Worker", "MovedBy(): false");
			return false;
		} 
		
		Szkeleton.kiir("<", "Worker", "MovedBy(): true");
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
	public void reduceNum() throws IOException {
		Game.getCurrentWH().reduceNumOfWorkers();
		
	}

	@Override
	public boolean ToPillar() throws IOException {
		
		Szkeleton.kiir(">", "Worker", "ToPillar()");
		if(byEntity != null) {
			System.out.println("Nullos vagyok... Haltam...");
			Szkeleton.kiir("<", "Worker", "ToPillar(): true");
			return true;
		}
		Szkeleton.kiir("<", "Worker", "ToPillar(): false");
		return false;
	}
}
