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
	private static String WHfile; //a fajl, ahol a jatekokat tartoljuk.
	
	public Game(String file) throws FileNotFoundException, IOException {
		WHfile = file;
		readWHs();
	}
	
	private static void readWHs() throws IOException {
		Szkeleton.kiir(">", "Game", "readWHs()");
		WareHouse warehouse = new WareHouse(null);
		Szkeleton.kiir("<", "Game","readWHs()");
	}
	
	public void ShowWHs() throws IOException {
		Szkeleton.kiir(">", "Game", "ShowWHs()");
		Szkeleton.kiir("<", "Game", "ShowWHs()");
	}
	
	public static void NewGame() { //kiszedtem az int parametert, mivel a palya kivalasztasa utan mar tudjuk, melyik palyan folyik a jatek (currentWarehouse), igy felesleges atadni a sorszamat.
		//Worker hozzaadasa
		Worker w1 = new Worker();
		Worker w2 = new Worker();
		currentWarehouse.AddWorker(w1, new Vec2D(1,1));
		currentWarehouse.AddWorker(w2, new Vec2D(1,2));
		//w2.Move(w2, Direction.UP);
		//w2.Move(w2, Direction.UP);
		w1.Move(null, Direction.UP);
		w1.Move(null, Direction.RIGHT);
		//System.out.println(w.tile.position.toString());
		
		
	}
	
	public void EndGame() {
		// TODO meg kollene irni
	}
	
	public static WareHouse getCurrentWH() {
		return currentWarehouse;
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Game game = new Game("game.txt");
		
		
		String key = null;
		do {
			key = Szkeleton.kiir("?", "", "");
			
			
			//parancsok listazasa
			if(key.equals("help")) {
				System.out.println("Start (start)");
				System.out.println("Show Warehouses (showwh)");
				System.out.println("Exit (exit)");
			}
			
			//WH-k kilistazasa
			else if(key.equals("showwh")) game.ShowWHs();
			
			//Palya valasztas es jatek inditas
			else if(key.equals("start")) {
				readWHs(); // ujra beolvassuk a fajlt, hogy az eredeti palyaallapotokat kapjuk vissza
				System.out.print("Melyik palyat valasztod? (0-" + (numOfWHs - 1) + ") ");
				//key = br.readLine();
				if (Integer.parseInt(key) >= numOfWHs)
					System.out.println("Nincs ilyen palya.");
				else {
					currentWarehouse = warehouses[Integer.parseInt(key)]; // aktualis palya beallitasa
					NewGame();
				}
			}
			Szkeleton.melyseg--;
		} while(!key.equals("exit"));
		
	}
}
