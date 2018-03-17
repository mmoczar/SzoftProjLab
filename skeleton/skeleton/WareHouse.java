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
	
	private Tile[][] tiles = new Tile[2][2];
	
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
	
	public void AddWorker(Worker w, Vec2D pos) throws IOException { 
		Szkeleton.kiir(">", "WareHouse", "AddWorker(w, pos)");
		//Worker elhelyezese a palyan plusz worker tile mezojenek beallitasa
		Tile t = new Tile();
		w.SetTile(t);
		t.SetEntity(w);
		Szkeleton.kiir("<", "WareHouse", "AddWorker(w, pos)");
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
