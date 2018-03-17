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
	
	public WareHouse(ArrayList<String> map) {
		//Map dimenzioinak kiszedese az elso sorbol
		String[] dimension = map.get(0).split(" ");
		width = Integer.parseInt(dimension[0]);
		height = Integer.parseInt(dimension[1]);
		map.remove(0);
		//Generikus tomb beallitasa
		tiles = (Tile[][]) Array.newInstance(Tile.class, Integer.parseInt(dimension[0]),Integer.parseInt(dimension[1]));
		
		//Alap feltoltes Pillarokkal es Tileokkal. Pillarok a szelen
		for(int i= 0; i<height; i++) {
			for(int j = 0; j<width; j++) {
				if(i == 0 || i == height-1 || j == 0 || j == width-1) tiles[i][j] = new Pillar();
				else tiles[i][j] = new Tile();
			}
		}
		
		
		
		/*
		 * A trapdoorokat es a switcheket a fajlban egymas utan taroljuk
		 * es a beolvasasnal a trapdor alatti switch tartozik hozza.
		 */
		TrapDoor recenttrap = null;
		Target recenttarget = null;
		//Tile tipusok hozzaadasa
		for(int i = 0; i < map.size(); i++) {
			String[] temp_tile = map.get(i).split(" ");
			int x,y;
			
			x = Integer.parseInt(temp_tile[2]);
			y = Integer.parseInt(temp_tile[1]);
			
			if(temp_tile[0].equals("Hole")) tiles[x][y] = new Hole();
			
			else if(temp_tile[0].equals("Trapdoor")) {
				recenttrap = new TrapDoor();
				tiles[x][y] = recenttrap;
			}
			
			else if(temp_tile[0].equals("Switch")) {
				tiles[x][y] = new Switch(recenttrap);
				recenttrap = null;
			}
			
			else if(temp_tile[0].equals("Target")) {
				recenttarget = new Target();
				tiles[x][y] = recenttarget;
				numOfTargets++;
			}
			
			else if(temp_tile[0].equals("Box")) {
				Box currentBox = new Box();
				tiles[x][y].SetEntity(currentBox);
				recenttarget.AddBox(currentBox);
				numOfBoxes++;
				numOfMovableBoxes++;
			}
			
		}
		
		
		//Szomszedok beallitasa a perem kivetelevel
		for(int i= 1; i<height-1; i++) {
			for(int j = 1; j<width-1; j++) {
				tiles[i][j].setNeighbor(tiles[i+1][j], tiles[i-1][j], tiles[i][j-1], tiles[i][j+1]);
			}
		}
		
		 
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
