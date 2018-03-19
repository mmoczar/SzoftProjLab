import java.io.IOException;

/**
 * A pálya alapelemeit reprezentáló osztály
 */
public class Tile {
	protected Vec2D position;
	protected Entity entity = null;
	
	protected Tile tUP;
	protected Tile tDOWN;
	protected Tile tLEFT;
	protected Tile tRIGHT;

	// Default konstruktor
	public Tile() throws IOException {
		Szkeleton.kiir(">", "Tile", "Tile()");
		Szkeleton.kiir("<", "Tile", "Tile()");
	}
	
	public Tile(TrapDoor trap) {
	}

	// A Tile-on lévő Entity beállítása
	public void SetEntity(Entity e) throws IOException {
		Szkeleton.kiir(">", "Tile", "SetEntity(e)");
		entity = e;
		Szkeleton.kiir("<", "Tile", "SetEntity(e)");
	}
	
	//Szomszedos Tile keri ezt az Acceptet
	public boolean Accept(Entity e) throws IOException {
		Szkeleton.kiir(">", "Tile", "Accept(e)");
		Szkeleton.kiir("<", "Tile", "Accept(e): true");
		return true;
		
	}
	//Worker vagy Box keri ezt az Acceptet
	public void Accept(Entity e, Direction d) throws IOException { // TODO Ide nem kene mas fuggvenyhivas? (bence)

		Szkeleton.kiir(">", "Tile", "Accept(e,d)");
		Szkeleton.kiir("<", "Tile", "Accept(e,d)");

		
	}

	// Entity eltávolítása a mezőről
	public void Remove(Entity e) throws IOException {
		Szkeleton.kiir(">", "Tile", "Remove(e)");
		Szkeleton.kiir("<", "Tile", "Remove(e)");
	}

	// Szomszéd beállítása
	public void setNeighbor(Tile up, Tile down, Tile left, Tile right) {
		tUP = up;
		tDOWN = down;
		tLEFT = left;
		tRIGHT = right;
	}
	
	//Amikor mar egy masik Tile kerdezi
	public Entity GetEntityAt() throws IOException {
		Szkeleton.kiir(">", "Tile", "GetEntityAt()");
		Szkeleton.kiir("<", "Tile", "GetEntityAt()");
		return entity;
	}
	
	//Ez a fuggveny, amikor a worker kerdezi az alatta levo mezot, hogy mondja meg a szomszedon van-e Entity
	public Entity GetEntityAt(Direction d) throws IOException {
		Szkeleton.kiir(">", "Tile", "GetEntityAt(d)");
		switch(Szkeleton.kiir("?", "Mi van arra? (semmi, box, worker) ", "")) {
			case "semmi": Szkeleton.kiir("<", "Tile", "GetEntityAt(d): Entity");
						  return null;
			case "box": Szkeleton.kiir("<", "Tile", "GetEntityAt(d): Entity");
						return new Box();
			case "worker": Szkeleton.kiir("<", "Tile", "GetEntityAt(d): Entity");
						   return new Worker();
		}
		return null;
		
	}
	 // Debug fuggveny
	public void Hi() {
		if(entity == null) System.out.print("O");
		else entity.Hi();
	}
	
	public Vec2D pos() {
		return position;
	}
	
}
