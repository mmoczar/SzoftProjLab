import java.io.IOException;

/**
 * A palya alapelemeit reprezentalo osztaly
 */
public class Tile {
	protected Vec2D position;
	protected Entity entity = null;
	
	protected Tile tUP;
	protected Tile tDOWN;
	protected Tile tLEFT;
	protected Tile tRIGHT;

	/**
	 * Default konstruktor
	 * @throws IOException
	 */
	public Tile() throws IOException {

	}

	/**
	 *
	 * @param trap
	 */
	public Tile(TrapDoor trap) {
	}


	/**
	 * A Tile-on levo Entity beallitása
	 * @param e az entitiy
	 * @throws IOException
	 */
	public void SetEntity(Entity e) throws IOException {
		entity = e;
	}
	
	//Szomszedos Tile keri ezt az Acceptet

	/**
	 * Kezeli a ra erkezo entityket
	 * @param e	az entity
	 * @return	ide mozoghat-e az entity
	 * @throws IOException
	 */
	public boolean Accept(Entity e) throws IOException {

		return true;
		
	}

	/**
	 * Kezeli az adott iránybol érkező ra erkezo entityket
	 * @param e	az entity
	 * @param d	az irany
	 * @throws IOException
	 */
	public void Accept(Entity e, Direction d) throws IOException { // TODO Ide nem kene mas fuggvenyhivas? (bence)

		
	}


	/**
	 * Entity eltavolítasa a mezorol
	 * @throws IOException
	 */
	public void Remove() throws IOException {

	}


	/**
	 * Szomszedok beallitasa
	 * @param up	felso szomszed
	 * @param down	also szomszed
	 * @param left	bal szomszed
	 * @param right	jobb szomszed
	 */
	public void setNeighbor(Tile up, Tile down, Tile left, Tile right) {
		tUP = up;
		tDOWN = down;
		tLEFT = left;
		tRIGHT = right;
	}
	

	/**
	 * Visszaadja a rajtal levo enitityt
	 * @return	az enitity
	 * @throws IOException
	 */
	public Entity GetEntityAt() throws IOException {

		return entity;
	}
	
	//Ez a fuggveny, amikor a worker kerdezi az alatta levo mezot, hogy mondja meg a szomszedon van-e Entity

	/**
	 * Megkerdezi egy szomszedjatol az entityjet
	 * @param d	melyik szomszed
	 * @return	a rajta lévő entity
	 * @throws IOException
	 */
	public Entity GetEntityAt(Direction d) throws IOException {
		
		return null;
		
	}


	/**
	 * Debug fv
	 */
	public void Hi() {
		if(entity == null) System.out.print(" ");
		else entity.Hi();
	}

	/**
	 * Debug fv
	 * @return
	 */
	public Vec2D pos() {
		return position;
	}
	
}
