import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * A jatek elinditasat, befejezeset, a palya fajlok beolvasasat �s a jatekos altali palya valasztast teszi lehetove.
 */
public class Game {
	/**
	 * Az aktualis jatek altal hasznalt palya.
	 */
	private static WareHouse currentWarehouse;
	/**
	 * A palya fajlokbol beolvasott palyak tarolasa.
	 */
	private static WareHouse[] warehouses;
	/**
	 * Raktarak szama.
	 */
	private static int numOfWHs; // a szkeletonhoz. a grafikus feluleten majd ugyis kattintassal valaszt, es nem tud "rosszat", addig is muszaj vedeni valahogy a tulindexelest.
<<<<<<< HEAD
	/**
	 * A fajl, ahol a jatekokat taroljuk.
	 */
	private static String WHfile = "game.txt"; //a fajl, ahol a jatekokat tartoljuk.
	/**
	 * Az osztaly konstruktora, ami beolvassa kulso fajlokbol a palyakat.
	 * @param file a kivalasztott palya
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
=======
	private static String WHfile; //a fajl, ahol a jatekokat tartoljuk.
	
>>>>>>> dd89ec5f3012436e67bc109994442b924c599eaf
	public Game(String file) throws FileNotFoundException, IOException {
		WHfile = file;
	}
	/**
	 * Beolvassa a raktarakat.
	 * @throws IOException
	 */
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
<<<<<<< HEAD
	/**
	 * Kilistazza a beolvasott palyakat.
	 * @throws IOException
	 */
	public void ShowWHs() throws IOException {
		
	}
	
	/**
	 * Elinditja a jatekot a parameterul kapott palyaval.
	 * @throws IOException
	 */
	public static void NewGame() throws IOException { 

	}
	
	/**
	 * Kiirja a gyoztes jatekost es a szerzett pontokat.
	 */
=======
	
	public static void ShowWHs() throws IOException {
		for(int i = 0; i < warehouses.length; i++) {
			System.out.println("--------------- WH ID: " + i + " ---------------");
			warehouses[i].draw();
			System.out.println("");
		}
		
	}
	

	public static void NewGame(int wh) throws IOException { 
		currentWarehouse = warehouses[wh];
		currentWarehouse.AddWorker(new Worker("Mario"), 3, 6);
		currentWarehouse.draw();
	}
	
	

>>>>>>> dd89ec5f3012436e67bc109994442b924c599eaf
	public void EndGame() {
		// TODO meg kollene irni
	}
	
	/**
	 * Visszaadja az aktualis raktarat.
	 * @return aktualis raktar
	 */
	public static WareHouse getCurrentWH() {
		return currentWarehouse;
	}
	/**
	 * Fo metodus, itt indul el a program. Letrehoz egy Game objektumot, es beolvassa a raktarakat.
	 * @param args args
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Game game = new Game("game.txt");
		game.readWHs();
		game.ShowWHs();
		
		
		game.NewGame(0);
		
		
		
	}
}
