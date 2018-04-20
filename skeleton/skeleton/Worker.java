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
	Tile tile;
	private double power;

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
		tile = t;
		System.out.println("SET");
		if(tile == null) System.out.println("Hazudtam");
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
		Tile temp = tile;

		if(temp.GetNbTile(d).Accept(this, d)){
			System.out.println("Sikeres mozgas");
			temp.Remove(/*this*/);
			return true;
		}
		else {
			System.out.println("Sikertelen mozgas");
			return false;
		} 
		
				
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
		if(e == null) return false;
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
	
	public String Hello() {
		return "Worker";
	}
	
	public void setPower(double p) {
		power = p;
	}
	
	public double getPower() {
		return power;
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
