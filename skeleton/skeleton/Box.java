import java.io.IOException;

/**
 * Doboz
 */
public class Box extends Entity {
	
	private Target target;
	private Worker worker;
	

	// Doboz mozog
	@Override
	public boolean Move(Entity e, Direction d) throws IOException {
		Szkeleton.kiir(">", "Box", "Move()");
		if(d == Direction.UP) {
		Tile tile = new Tile();
		Entity nb = tile.GetEntityAt(Direction.UP);
	
		if(nb == null) {
			if(tile.Accept(this))
			{
				Szkeleton.kiir("<", "Box", "Move(): true");
				return true;
			}
			Szkeleton.kiir("<", "Box", "Move(): false");
			return false;
		}
		else {
			if(nb.MovedBy(e)) {
				if(nb.Move(this, Direction.UP)) {
					Szkeleton.kiir("<", "Box", "Move(): true");
					return true;
				}
			}
		}
		}
		if(d == Direction.DOWN) {
			Tile tile = new Hole();
			tile.Accept(this);
			Szkeleton.kiir("<", "Box", "Move(): true");
			return true;
		}
		Szkeleton.kiir("<", "Box", "Move(): false");
		return false;
	}

	// Dobozt elmozgatják
	@Override
	public boolean MovedBy(Entity e) throws IOException {
		Szkeleton.kiir(">", "Box", "MovedBy()");
		Szkeleton.kiir("<", "Box", "MovedBy(): true");
		return true;
	}
	
	// A lada hat a kapcsolora
	@Override
	public boolean SwitchAction() throws IOException {
		Szkeleton.kiir(">", "Box", "SwitchAction()");
		Szkeleton.kiir("<", "Box", "SwitchAction(): box");
		return true;
	}

	// Debug fv
	@Override
	public void Hi() {
		System.out.print("B");
		
	}

	// Doboz eltünésekor
	@Override
	public void reduceNum() throws IOException {
		Szkeleton.kiir(">", "Box", "reduceNum()");

		Game.getCurrentWH().reduceNumOfBoxes();
		Game.getCurrentWH().reduceNumOfMovableBoxes();
		Szkeleton.kiir("<", "Box", "reduceNum()");

	}
	// Tile beállítása
	public void SetTile(Tile t) {
		// TODO Auto-generated method stub
		
	}

	// Oszlopnak ütközik
	@Override
	public boolean ToPillar() {
		return false;
	}




}
