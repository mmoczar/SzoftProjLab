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
	}
	
	//Worker mozgatasa
	@Override
	public boolean Move(Entity e, Direction d) throws IOException {
		//Ellenorzi hogy az adott iranyban van-e valaki
		Entity nb = tile.GetEntityAt(d); 
		if(nb == null){
			System.out.println("Mellttem nincs semmi");
			tile.Accept(this, d);
		}
		else {
			System.out.println("Itt van valami");
			if(nb.MovedBy(e)) {
				System.out.println("El tudom tolni");
				nb.Move(this, d);
				tile.Accept(this, d);
			} 
			else System.out.println("Nem tudom tolni");
		} 
		
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
