import java.io.IOException;


/**
 * A játékos álltal mozgatott Entity
 */
public class Worker extends Entity {

	
	private int numOfPlacedBoxes;
	private Entity byEntity;

	// Default konstruktor
	public Worker() throws IOException {

	}

	// Tile beállítása
	public void SetTile(Tile t) throws IOException {

	}
	
	//Worker mozgatasa
	@Override
	public boolean Move(Entity e, Direction d) throws IOException {
			
			return false;
				
	}
	
	// a munkas nem hat a kapcsolora
	@Override
	public boolean SwitchAction() throws IOException {

		return false;
	}

	// Worker tolhatosaganak ellenorzese
	@Override
	public boolean MovedBy(Entity e) throws IOException {
		
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
