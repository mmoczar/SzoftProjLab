import java.io.IOException;


/**
 * A játékos álltal mozgatott Entity
 */
public class Worker extends Entity {

	private String name;
	private int numOfPlacedBoxes;
	private Entity byEntity;
	private Tile tile;

	// Default konstruktor
	public Worker(String name) throws IOException {
		this.name = name;
	}

	// Tile beállítása
	public void SetTile(Tile t) throws IOException {
		tile = t;
		System.out.println("SET");
		if(tile == null) System.out.println("Hazudtam");
	}
	
	//Worker mozgatasa
	@Override
	public boolean Move(Entity e, Direction d) throws IOException {
		Tile temp = tile;

		if(temp.GetNbTile(d).Accept(this, d)){
			System.out.println("Sikeres mozgas");
			temp.Remove(this);
			return true;
		}
		else {
			System.out.println("Sikertelen mozgas");
			return false;
		} 
		
				
	}
	
	// a munkas nem hat a kapcsolora
	@Override
	public boolean SwitchAction() throws IOException {

		return false;
	}

	// Worker tolhatosaganak ellenorzese
	@Override
	public boolean MovedBy(Entity e) throws IOException {
		if(e == null) return false;
		return true;
		
	}
	
	public void Die() {
		
	}
	
	public void AddPlacedBox() {
		numOfPlacedBoxes++;
	}
	
	
	public void Hi() {
		System.out.print("W");
	}

	@Override
	public void reduceNum() throws IOException {
		Game.getCurrentWH().reduceNumOfWorkers();
		
	}

	//Pillarnak lepes
	@Override
	public boolean ToPillar() throws IOException {
		
		return false;
	}
}
