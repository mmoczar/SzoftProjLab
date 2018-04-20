import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Game {
	private static WareHouse currentWarehouse;
	private static WareHouse[] warehouses;
	private static int numOfWHs; // a szkeletonhoz. a grafikus feluleten majd ugyis kattintassal valaszt, es nem tud "rosszat", addig is muszaj vedeni valahogy a tulindexelest.
	private static String WHfile; //a fajl, ahol a jatekokat tartoljuk.
	
	public Game(String file) throws FileNotFoundException, IOException {
		WHfile = file;
	}
	
	private static void readWHs() throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(WHfile))) {
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
	
	public static void ShowWHs() throws IOException {
		for(int i = 0; i < warehouses.length; i++) {
			System.out.println("--------------- WH ID: " + i + " ---------------");
			warehouses[i].draw();
			System.out.println("");
		}
		
	}
	

	public static void NewGame(int wh) throws IOException { 
		currentWarehouse = warehouses[wh];
		Worker w1 = new Worker("Mario");
		currentWarehouse.AddWorker(w1, 3, 6);
		currentWarehouse.draw();
		
		w1.Move(null, Direction.UP);
		
		currentWarehouse.draw();
	}
	
	

	public void EndGame() {
		// TODO meg kollene irni
	}
	
	public static WareHouse getCurrentWH() {
		return currentWarehouse;
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Game game = new Game("game.txt");
		game.readWHs();
		game.ShowWHs();
		game.NewGame(0);
		
		
		
	}
}
