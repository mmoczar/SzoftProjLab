import java.lang.reflect.Array;
import java.util.ArrayList;

public class WareHouse {
	private int numOfBoxes;
	private int numOfTargets;
	private int numOfWorkers;
	private int numOfMovableBoxes;
	private int height;
	private int width;
	
	private Tile[][] tiles;
	
	public WareHouse(ArrayList<String> map) {
		//Map dimenzióinak kiszedése az első sorból
		String[] dimension = map.get(0).split(" ");
		width = Integer.parseInt(dimension[0]);
		height = Integer.parseInt(dimension[1]);
		map.remove(0);
		//Generikus tömb beállítása
		tiles = (Tile[][]) Array.newInstance(Tile.class, Integer.parseInt(dimension[0]),Integer.parseInt(dimension[1]));
		
		//Alap feltöltés Pillarokkal és Tileokkal. Pillarok a szélén
		for(int i= 0; i<height; i++) {
			for(int j = 0; j<width; j++) {
				if(i == 0 || i == height-1 || j == 0 || j == width-1) tiles[i][j] = new Pillar();
				else tiles[i][j] = new Tile();
			}
		}
		
		
		
		/*
		 * A trapdoorokat és a switcheket a fájlban egymás után tároljuk
		 * és a beolvasásnál a trapdor alatti switch tartozik hozzá.
		 */
		TrapDoor recenttrap = null;
		Target recenttarget = null;
		//Tile típusok hozzáadása
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
				
			}
			
			else if(temp_tile[0].equals("Box")) {
				Box currentBox = new Box();
				tiles[x][y].SetEntity(currentBox);
				recenttarget.AddBox(currentBox);
			}
			
		}
		
		
		//Szomszédok beállítása aperem kivételével
		for(int i= 1; i<height-1; i++) {
			for(int j = 1; j<width-1; j++) {
				tiles[i][j].setNeighbor(tiles[i+1][j], tiles[i-1][j], tiles[i][j-1], tiles[i][j+1]);
			}
		}
		
		 
	}
	//Konzolos kirajzolás
	public void draw() {
		for(int i= 0; i<height; i++) {
			for(int j = 0; j<width; j++) {
				tiles[i][j].Hi();
				}
			System.out.println("");
			}
	}
	
	public void AddWorker(Worker w, Vec2D pos) { 
		//Worker elhelyezése a pályán plusz worker tile mezőjének beállítása
		w.SetTile(tiles[pos.getX()][pos.getY()]);
		tiles[pos.getX()][pos.getY()].SetEntity(w);

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
}
