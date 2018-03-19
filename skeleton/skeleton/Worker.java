import java.io.IOException;

public class Worker extends Entity {

	
	private int numOfPlacedBoxes;
	private Entity byEntity;

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
			// If else - ek a tesztesetek szetvalasztasara
			
			//Ellenorzi hogy az adott iranyban van-e valaki
			byEntity = e;
			
			//Player move (playermove) teszteset
			if(d == Direction.UP) {
			Szkeleton.kiir(">", "Worker", "Move()");
			
			//A szomszedos mezo letrehozasa, hogy oda tudjon lepni a worker
			Tile tile = new Tile();
			
			//Szomszedos mezon levo entity ellenorzese
			Entity nb = tile.GetEntityAt(Direction.UP);
			
			//Ha nincs szomszed szabad a mozgas
			if(nb == null) {
				//Ha a Tile is lehetove teszi a mozgast(nem pillar)
				if(tile.Accept(this))
				{
					Szkeleton.kiir("<", "Worker", "Move(): true");
					return true;
				}
				Szkeleton.kiir("<", "Worker", "Move(): false");
				return false;
			}
			//Van entity a szomszedos mezon
			else {
				//Ellenorzes, hogy el tudja-e tolni az adott entity-t
				if(nb.MovedBy(e)) {
					//Meghivja a szomszedos enity move-metodusat - ha true-val tér vissza akkor sikeres a mozgas
					if(nb.Move(this, Direction.UP)) {
						Szkeleton.kiir("<", "Worker", "Move(): true");
						return true;
					}
				}
			}
			}
			
			// Teszteset amikor a worker lyukra mozog
			if(d == Direction.DOWN) {
				//Hole tipusu Tile letrehozasa
				Tile tile = new Hole();
				// Hole ra lepes
				tile.Accept(this);
				Szkeleton.kiir("<", "Worker", "Move(): true");
				return true;
			}
			
			//Teszteset amikor a worker pillarfele mozog (csak az amikor a workert a jatekos mozgatja a pillarnak)
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

	// Worker tolhatosaganak ellenorzese
	@Override
	public boolean MovedBy(Entity e) throws IOException {
		Szkeleton.kiir(">", "Worker", "MovedBy()");
		//Amikor egy worker elkezdi a mozgast van egy null parametere ami azt mutatja hogy
		//o kezdte a mozgast, ha egy ilyen akar eltorni egy masik munkast akkor false al ter vissza
		// mivel worker workert-t nem tolhat kozvetlenul
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
	public void reduceNum() {
		Game.getCurrentWH().reduceNumOfWorkers();
		
	}

	//Pillarnak lepes
	@Override
	public boolean ToPillar() throws IOException {
		
		Szkeleton.kiir(">", "Worker", "ToPillar()");
		// Ez az az eset amikor a munkas kozvetetten bozok es pillarra lepesnel meghal
		if(byEntity != null) {
			System.out.println("Nullos vagyok... Haltam...");
			Szkeleton.kiir("<", "Worker", "ToPillar(): true");
			return true;
		}
		
		//Amikor siman mozog neki, nem tortenik semmi (lepattan)
		Szkeleton.kiir("<", "Worker", "ToPillar(): false");
		return false;
	}
}
