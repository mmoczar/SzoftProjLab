import java.io.IOException;

/**
 * Doboz
 */
public class Box extends Entity {
	
	private Target target;
	private Worker worker;
	

	// Doboz mozog
	@Override
	public boolean Move(Entity e, Direction d) throws IOException {
		
		return false;
	}

	// Dobozt elmozgatják
	@Override
	public boolean MovedBy(Entity e) throws IOException {

		return true;
	}
	
	// A lada hat a kapcsolora
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
	public void SetTile(Tile t) {
		// TODO Auto-generated method stub
		
	}

	// Oszlopnak ütközik
	@Override
	public boolean ToPillar() {
		return false;
	}




}
