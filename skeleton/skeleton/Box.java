import java.io.IOException;

/**
 * Ladat reprezentalo osztaly.
 */
public class Box extends Entity {
	/**
	 * A ladahoz tartozo celmezo.
	 */
	private Target target;
	/**
	 * A tolast megkezdo munkas.
	 */
	private Worker worker;
	

	// Doboz mozog
	/**
	 * Adott iranyba lep egyet, ha sikerult lepni, akkor igazzal, ha nem sikerult lepni, akkor hamissal ter vissza.
	 * @param e entitas
	 * @param d irany
	 * @return sikerult-e elmozogni
	 */
	@Override
	public boolean Move(Entity e, Direction d) throws IOException {
		return false;
	}

	// Dobozt elmozgatjak
	/**
	 * Visszaadja, hogy el tudtak-e tolni.
	 * @param entitas, mely tolja
	 * @return el tudtak-e tolni
	 */
	@Override
	public boolean MovedBy(Entity e) throws IOException {

		return true;
	}
	
	// A lada hat a kapcsolora
	/**
	 * A lada hatassal van a kapcsolora, igazzal ter vissza.
	 * @return hatassal van-e a kapcsolora
	 */
	@Override
	public boolean SwitchAction() throws IOException {

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



	}
	// Tile beállítása
	/**
	 * Beallitja azt a mezot, amelyiken a lada van.
	 * @param t beallitando mezo
	 */
	public void SetTile(Tile t) {
		// TODO Auto-generated method stub
		
	}

	// Oszlopnak ütközik
	/**
	 * Oszlopnak utkozik.
	 * @return hamis
	 */
	@Override
	public boolean ToPillar() {
		return false;
	}




}
