import java.io.IOException;


/**
 * Egy munkast reprezental. A jatekos ennek iranyitasaval tolhatja a ladakat a megfelelo iranyba.
 */
public class Worker extends Entity {
	/**
	 * A jatekos neve
	 */
	private String name;
	/**
	 * A munkas altal helyere tett ladak szama.
	 */
	private int numOfPlacedBoxes;

	//TODO kitalalni, hogy mire jo.
	private Entity byEntity;

	/**
	 * Default konstruktor
	 * @param name
	 * @throws IOException
	 */
	public Worker(String name) throws IOException {
		this.name = name;
	}

	/**
	 * Tile beallitasa
	 * @param t
	 * @throws IOException
	 */
	public void SetTile(Tile t) throws IOException {

	}

	/**
	 * A munkas mozgatasa.
	 * @param e
	 * @param d
	 * @return A munkás el tud-e mozogni.
	 * @throws IOException
	 */
	@Override
	public boolean Move(Entity e, Direction d) throws IOException {
			
		return false;
				
	}

	/**
	 * A munkas nem hat a kapcsolora.
	 * @return Mindig hamis.
	 * @throws IOException
	 */
	@Override
	public boolean SwitchAction() throws IOException {

		return false;
	}

	/**
	 * A munkas tolhatosaganak ellenorzese.
	 * @param e
	 * @return A munkast el lehet-e tolni.
	 * @throws IOException
	 */
	@Override
	public boolean MovedBy(Entity e) throws IOException {
		
		return true;
		
	}

	/**
	 * A munkas meghal.
	 */
	public void Die() {
		
	}

	/**
	 * Egy lada helyere lokesekor noveli a munkás helyre tett ladainak szamat.
	 */
	public void AddPlacedBox() {
		numOfPlacedBoxes++;
	}

	/**
	 * Debug fuggveny.
	 */
	public void Hi() {
		System.out.print("W");
	}

	/**
	 * Csokkenti az aktualisan a Warehouse-ban levo Worker-ek szamat.
	 * @throws IOException
	 */
	@Override
	public void reduceNum() throws IOException {
		Game.getCurrentWH().reduceNumOfWorkers();
		
	}

	/**
	 * Pillarnak lepes.
	 * @return
	 * @throws IOException
	 */
	@Override
	public boolean ToPillar() throws IOException {
		
		return false;
	}
}
