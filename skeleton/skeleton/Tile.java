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

	}
	
	public Tile(TrapDoor trap) {
	}

	// A Tile-on lévő Entity beállítása
	public void SetEntity(Entity e) throws IOException {

	}
	
	//Szomszedos Tile keri ezt az Acceptet
	public boolean Accept(Entity e) throws IOException {

		return true;
		
	}
	//Worker vagy Box keri ezt az Acceptet
	public void Accept(Entity e, Direction d) throws IOException { // TODO Ide nem kene mas fuggvenyhivas? (bence)



		
	}

	// Entity eltávolítása a mezőről
	public void Remove(Entity e) throws IOException {

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

		return entity;
	}
	
	//Ez a fuggveny, amikor a worker kerdezi az alatta levo mezot, hogy mondja meg a szomszedon van-e Entity
	public Entity GetEntityAt(Direction d) throws IOException {
		
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
