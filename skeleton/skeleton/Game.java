import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Game {
	private static WareHouse currentWarehouse = null;
	private static WareHouse[] warehouses;
	private static int numOfWHs; // a szkeletonhoz. a grafikus feluleten majd ugyis kattintassal valaszt, es nem tud "rosszat", addig is muszaj vedeni valahogy a tulindexelest.
	
	public Game(String file) throws FileNotFoundException, IOException {
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    
		    //Elso sor beolvasasa, ami egy szam és megmutatja hany raktar lesz
		    line = br.readLine();
		    //Generikus tomb letrahozasa a megfelelo szamra
		    warehouses = (WareHouse[]) Array.newInstance(WareHouse.class, Integer.parseInt(line));
		    numOfWHs = Integer.parseInt(line);
		    
		    //Mapok beolvasasa fajlbol, ha uj map, akkor a faljban azt egy + jelzi
		    ArrayList<String> map = new ArrayList<String>();
		    int i = 0;
		    while ((line = br.readLine()) != null) {
		    	if(line.equals("+")) {
		    		//System.out.println("Létrehozom");
		    		warehouses[i] = new WareHouse(map);
		    		map.clear();
		    		i++;
		    	}
		    	else {
		    		//System.out.println("Adatok...");
		    		map.add(line);
		    	}
		    }
		}
	}
	
	public void ShowWHs() {
		for(int i = 0; i < warehouses.length; i++) {
			System.out.println("--------------- WH ID: " + i + " ---------------");
			warehouses[i].draw();
			System.out.println("");
		}
	}
	
	public static void NewGame() { //kiszedtem az int parametert, mivel a palya kivalasztasa utan mar tudjuk, melyik palyan folyik a jatek (currentWarehouse), igy felesleges atadni a sorszamat.
		//Worker hozzaadasa
		Worker w1 = new Worker();
		Worker w2 = new Worker();
		currentWarehouse.AddWorker(w1, new Vec2D(1,1));
		currentWarehouse.AddWorker(w2, new Vec2D(2,1));
		//w2.Move(w2, Direction.UP);
		w2.Move(w2, Direction.RIGHT);
		//w1.Move(null, Direction.DOWN);
		//System.out.println(w.tile.position.toString());
		
		
	}
	
	public void EndGame() {
		
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Game game = new Game("game.txt");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String key = null;
		do {
						
			key = br.readLine();
			
			//parancsok listazasa
			if(key.equals("help")) {
				System.out.println("Start (start)");
				System.out.println("Show current Warehouse (showcwh)");
				System.out.println("Show Warehouses (showwh)");
				System.out.println("Exit (exit)");
			}
			
			//WH-k kilistazasa
			else if(key.equals("showwh")) game.ShowWHs();
			
			//aktualis WH kirajzolasa (amin eppen fut a jatek)
			else if (key.equals("showcwh")) {
				if (currentWarehouse == null)
					System.out.println("Elobb valassz palyat! (start utasitas)");
				else
					currentWarehouse.draw();
			}
			
			//Palya valasztas es jatek inditas
			else if(key.equals("start")) {
				System.out.print("Melyik palyat valasztod? (0-" + (numOfWHs - 1) + ") ");
				key = br.readLine();
				if (Integer.parseInt(key) >= numOfWHs)
					System.out.println("Nincs ilyen palya.");
				else {
					currentWarehouse = warehouses[Integer.parseInt(key)]; // aktualis palya beallitasa
					NewGame();
				}
			}
			
		} while(!key.equals("exit"));
		
	}
}
