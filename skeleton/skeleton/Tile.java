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
	
	public Tile GetNbTile(Direction d) {
		switch(d){
		case UP: return tUP; 
		case DOWN: return tDOWN; 
		case LEFT: return tLEFT; 
		case RIGHT: return tRIGHT;
		default: return null;
		}
	}


	/**
	 * A Tile-on levo Entity beallitása
	 * @param e az entitiy
	 * @throws IOException
	 */
	public void SetEntity(Entity e) throws IOException {
		entity = e;
		e.SetTile(this);
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
<<<<<<< HEAD
	//Worker vagy Box keri ezt az Acceptet
	public boolean Accept(Entity e, Direction d) throws IOException { // TODO Ide nem kene mas fuggvenyhivas? (bence)
		if(entity == null) {
			entity = e;
			
			e.SetTile(this);
			System.out.println("Sikeres Accept");
			return true;
		}
		else {
			return entity.Move(e, d);
		}
		
		
=======

	/**
	 * Kezeli az adott iránybol érkező ra erkezo entityket
	 * @param e	az entity
	 * @param d	az irany
	 * @throws IOException
	 */
	public void Accept(Entity e, Direction d) throws IOException { // TODO Ide nem kene mas fuggvenyhivas? (bence)
>>>>>>> 1d247a64c97996a93641253ba67961c7d55d962f

		
	}

<<<<<<< HEAD
	// Entity eltávolítása a mezőről
	public void Remove(Entity e) throws IOException {
		entity = null;
=======

	/**
	 * Entity eltavolítasa a mezorol
	 * @throws IOException
	 */
	public void Remove() throws IOException {

>>>>>>> 1d247a64c97996a93641253ba67961c7d55d962f
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
		switch(d) {
		case UP: return tUP.GetEntityAt(); 
		case DOWN: return tDOWN.GetEntityAt(); 
		case LEFT: return tLEFT.GetEntityAt(); 
		case RIGHT: return tRIGHT.GetEntityAt();
		default:
			break;
		}
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
