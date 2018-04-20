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

	/**
	 * Eloszor ralep az entitas, es ha nyitva van, akkor leejti
	 * @param e
	 * @param d
	 * @throws IOException
	 */
	public void Accept(Entity e, Direction d) throws IOException {
		super.Accept(e, d);
		if(state) DropEntity(e); // ha nyitva, leejti
	}

	/**
	 * A mezon levo enity leejtese
	 * @param e
	 * @throws IOException
	 */
	public void DropEntity(Entity e) throws IOException {

	}
	
}
