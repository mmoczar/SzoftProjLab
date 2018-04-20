import java.io.IOException;

/**
 * Entitast reprezentalo absztrakt osztaly.
 */
public abstract class Entity {
	/**
	 * A mezo, amelyen eppen all.
	 */
	protected Tile tile;
	
	/**
	 * Beallitja a mezot, amelyikre lepett.
	 * @param t mezo
	 * @throws IOException
	 */
	public abstract void SetTile(Tile t) throws IOException;
	
	/**
	 * Adott iranyba lep egyet, ha sikerult lepni, akkor igazzal, ha nem sikerult lepni, akkor hamissal ter vissza.
	 * @param e entitas
	 * @param d irany
	 * @return sikerult-e elmozogni
	 * @throws IOException
	 */
	public abstract boolean Move (Entity e, Direction d) throws IOException;
	
	/**
	 * Visszaadja, hogy el tudtak-e tolni.
	 * @param e entitas, mely tolja
	 * @return el tudtak-e tolni
	 * @throws IOException
	 */
	public abstract boolean MovedBy(Entity e) throws IOException;
	
	/**
	 * A lada hatassal van a kapcsolora, igazzal ter vissza.
	 * @return hatassal van-e a kapcsolora
	 * @throws IOException
	 */
	public abstract boolean SwitchAction() throws IOException;
	
	/**
	 * Csokkenti az entitasok szamat.
	 * @throws IOException
	 */
	public abstract void reduceNum() throws IOException;
	
	//debug
	
	public abstract void Hi();

	public abstract boolean ToPillar() throws IOException;
}
