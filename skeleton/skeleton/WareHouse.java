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
				if(i == 0 || i == height-1 || j == 0 || j == width-1) tiles[i][j] = new Pillar(new Vec2D(i,j));
				else tiles[i][j] = new Tile(new Vec2D(i,j));
			}
		}
		
		//Tile típusok hozzáadása
		for(int i = 0; i < map.size(); i++) {
			String[] temp_tile = map.get(i).split(" ");
			int x,y;
			x = Integer.parseInt(temp_tile[1]);
			y = Integer.parseInt(temp_tile[2]);
			if(temp_tile[0].equals("Hole")) tiles[x][y] = new Hole(new Vec2D(x,y));
		}
		
		
		
		/* Egyszerű debug kirajzolás*/
		for(int i= 0; i<height; i++) {
			for(int j = 0; j<width; j++) {
				tiles[i][j].Hi();
				}
			System.out.println("");
			}
		 
	}
	
	public void AddEntity(Entity e) {
		
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
