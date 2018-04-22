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
	private int numOfPlacedBoxes = 0;

	//TODO kitalalni, hogy mire jo.
	private Entity byEntity;
	Tile tile;
	private int power;

	/**
	 * Default konstruktor
	 * @param name
	 * @throws IOException
	 */
	public Worker(String name, int pow) throws IOException {
		this.name = name;
		power = pow;
	}

	/**
	 * Tile beallitasa
	 * @param t
	 * @throws IOException
	 */
	public void SetTile(Tile t) throws IOException {
		tile = t;
	}

	/**
	 * A munkas mozgatasa.
	 * @param e
	 * @param d
	 * @return A munkás el tud-e mozogni.
	 * @throws IOException
	 */
	@Override
	public boolean Move(Entity e, Direction d, Worker w) throws IOException {
		Tile temp = tile;
		int pow_temp = power;

		if(temp.GetNbTile(d).Accept(this, d, w)){
			System.out.println("Sikeres mozgas");
			temp.Remove(/*this*/);
			
			System.out.println(power);
			
			power = pow_temp;
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
		System.out.println(name + ": Meghaltam...");
	}

	/**
	 * Egy lada helyere lokesekor noveli a munkás helyre tett ladainak szamat.
	 */
	public void AddPlacedBox() {
		numOfPlacedBoxes++;
		System.out.println(name + " - betolt egy dobozt a megfelelo targetre");
		System.out.println("Pontja: "+ numOfPlacedBoxes);
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
	
	public void setPower(int p) {
		power = p;
	}
	
	public int getPower() {
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
		
		return true;
	}

	@Override
	public Target getTarget() {
		return null;
	}
}
