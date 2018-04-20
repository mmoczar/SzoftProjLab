import java.io.IOException;


/**
 * A csapoajtot reprezentalja. Allapotatol fugg, hogy egyszeru mezokent (Tile), vagy lyukkent (Hole) viselkedik.
 */
public class TrapDoor extends Tile {

	/**
	 * Alapbol zarva
	 */
	private boolean state = false;
	//protected Switch Switch;

	/**
	 * Default konstruktor
	 * @throws IOException
	 */
	public TrapDoor() throws IOException {

	}

	/**
	 * Csapoajto allapotanak lekerdezese
	 * @return A csapoajto allapota.
	 * @throws IOException
	 */
	public boolean GetState() throws IOException {

		return state;
	}

	/**
	 * Csapoajto allapotanak atvaltasa
	 */
	public void SetState() {
		state = !state;
	}

	/**
	 * Debug fuggveny
	 */
	public void Hi() {
		System.out.print("T");
	}
<<<<<<< HEAD
	
	public String Hello() {
		return "TrapDoor";
	}
	
	// eloszor ralep az entitas, es ha nyitva van, akkor leejti
	public boolean Accept(Entity e, Direction d) throws IOException {
=======

	/**
	 * Eloszor ralep az entitas, es ha nyitva van, akkor leejti
	 * @param e
	 * @param d
	 * @throws IOException
	 */
	public void Accept(Entity e, Direction d) throws IOException {
>>>>>>> 1d247a64c97996a93641253ba67961c7d55d962f
		super.Accept(e, d);
		if(state) DropEntity(e); // ha nyitva, leejti
		return true;
	}

	/**
	 * A mezon levo enity leejtese
	 * @param e
	 * @throws IOException
	 */
	public void DropEntity(Entity e) throws IOException {

	}
	
}
