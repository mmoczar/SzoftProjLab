import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;


/**
 * A pályát reprezentáló osztály
 */
public class WareHouse {
	private int numOfBoxes = 0;
	private int numOfTargets = 0;
	private int numOfWorkers = 0;
	private int numOfMovableBoxes = 0;
	private int height;
	private int width;


	private Tile[][] tiles = new Tile[2][2];

	// Konstruktor
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

	// Worker hozzáadása a pályához
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

	// A pályán lévő dobozok száma
	public int GetNumOfBoxes() {
		return numOfBoxes;
	}

	// A pályán lévő dobozok számaának csökkentése
	public void reduceNumOfBoxes() throws IOException {
		Szkeleton.kiir(">", "WareHouse", "reduceNumOfBoxes()");
		numOfBoxes--;
		Szkeleton.kiir("<", "WareHouse", "reduceNumOfBoxes()");
	}

	// A pályán lévő munkások számaának csökkentése
	public void reduceNumOfWorkers() throws IOException {
		Szkeleton.kiir(">", "WareHouse", "reduceNumOfWorkers()");
		numOfWorkers--;
		Szkeleton.kiir("<", "WareHouse", "reduceNumOfWorkers()");
	}

	// Mozgatható dobozok száma
	public void reduceNumOfMovableBoxes() throws IOException {
		Szkeleton.kiir(">", "WareHouse", "reduceNumOfMovableBoxes()");
		numOfMovableBoxes--;
		Szkeleton.kiir("<", "WareHouse", "reduceNumOfMovableBoxes()");

	}
}
