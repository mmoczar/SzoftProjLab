import java.io.IOException;

public class Box extends Entity {
	
	private Target target;
	private Worker worker;
	
	
	@Override
	public boolean Move(Entity e, Direction d) throws IOException {
		Szkeleton.kiir(">", "Box", "Move()");
		// If else - ek a tesztesetek szetvalasztasara
		//Playermove (playermove)
		if(d == Direction.UP) {
		
		//Letrehozza a szomszedos Tile-t
		//Ellenorzi hogy az adott iranyban van-e valaki
		Tile tile = new Tile();
		Entity nb = tile.GetEntityAt(Direction.UP);
	
		//Amikor a szomszedos mezon nincs mas entity
		if(nb == null) {
			//A lepes sikeressegenek ellenorzese
			if(tile.Accept(this))
			{
				Szkeleton.kiir("<", "Box", "Move(): true");
				return true;
			}
			Szkeleton.kiir("<", "Box", "Move(): false");
			return false;
		}
		//Amikor van a szomszedos mezon masik entity
		else {
			//A tolhatosag vizsgalata
			if(nb.MovedBy(e)) {
				//A szomszedos entity mozgatasa
				if(nb.Move(this, Direction.UP)) {
					Szkeleton.kiir("<", "Box", "Move(): true");
					return true;
				}
			}
		}
		}
		
		//Teszteset amikor a box Hole-ra mozog
		if(d == Direction.DOWN) {
			Tile tile = new Hole();
			tile.Accept(this);
			Szkeleton.kiir("<", "Box", "Move(): true");
			return true;
		}
		Szkeleton.kiir("<", "Box", "Move(): false");
		return false;
	}

	//Mozgathatosag vizsgalata, a Box barmi altal mozgathato
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

	@Override
	public void reduceNum() throws IOException {
		Szkeleton.kiir(">", "Box", "reduceNum()");

		Game.getCurrentWH().reduceNumOfBoxes();
		Game.getCurrentWH().reduceNumOfMovableBoxes();
		Szkeleton.kiir("<", "Box", "reduceNum()");

	}
	public void SetTile(Tile t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	
	//Pillarra mozgas nem lehetseges a doboznal
	public boolean ToPillar() {
		return false;
	}

	@Override
	public void Hi() {
		// TODO Auto-generated method stub
		
	}




}
