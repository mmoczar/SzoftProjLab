import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class WareHouse {
	private int numOfBoxes = 0;
	private int numOfTargets = 0;
	private int numOfWorkers = 0;
	private int numOfMovableBoxes = 0;
	private int height;
	private int width;
	
	private Tile[][] tiles;
	
	public WareHouse(ArrayList<String> map) throws IOException {
		Szkeleton.kiir(">", "WareHouse", "WareHouse(map)");
		
		Tile t = new Tile();
		Hole h = new Hole();
		TrapDoor td = new TrapDoor();
		Target tg = new Target();
		Box b = new Box();
		Switch s = new Switch(); 
		Szkeleton.kiir("<", "WareHouse", "WareHouse(map)");
	}
	//Konzolos kirajzolas
	public void draw() {
		for(int i= height-1; i>=0; i--) {
			for(int j = 0; j<width; j++) {
				tiles[i][j].Hi();
				}
			System.out.println("");
			}
	}
	
	public void AddWorker(Worker w, Vec2D pos) { 
		//Worker elhelyezese a palyan plusz worker tile mezojenek beallitasa
		w.SetTile(tiles[pos.getX()][pos.getY()]);
		tiles[pos.getX()][pos.getY()].SetEntity(w);
		numOfWorkers++;
	}
	
	public Tile GetTileAt(Vec2D v) {
		return null;
		
	}
	
	public Vec2D GetDimension() {
		return null;
		
	}
	
	public int GetNumOfBoxes() {
		return numOfBoxes;
	}
	
	public void reduceNumOfBoxes() {
		numOfBoxes--;
	}
	public void reduceNumOfWorkers() {
		numOfWorkers--;
	}
	public void reduceNumOfMovableBoxes() {
		numOfMovableBoxes--;
	}
}
