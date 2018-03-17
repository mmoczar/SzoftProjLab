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
		Szkeleton.kiir("-", "Game konstruktor a jatek indulasakor.", "");
		Szkeleton.kiir(">", "Game", "Game(file)");
		WHfile = file;
		readWHs();
		Szkeleton.kiir("<", "Game", "Game(file)");
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
	

	public static void NewGame() throws IOException { //kiszedtem az int parametert, mivel a palya kivalasztasa utan mar tudjuk, melyik palyan folyik a jatek (currentWarehouse), igy felesleges atadni a sorszamat.
		Szkeleton.kiir(">", "Game", "NewGame()");
		Worker w1 = new Worker();
		currentWarehouse = new WareHouse(null);
		currentWarehouse.AddWorker(w1, new Vec2D(1,1));
		Szkeleton.kiir("<", "Game", "NewGame()");

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
				System.out.println("-   Start (start)");
				System.out.println("-   Show Warehouses (showwh)");
				System.out.println("-   Box on Switch, switch trapdoor's state (bos)");
				System.out.println("-   Worker on Switch, nothing happens (wos)");
				System.out.println("-   Entity on TrapDoor, TrapDoor opens -> Entity falls (eot)");
				System.out.println("-   Exit (exit)");
			}
			
			//WH-k kilistazasa
			else if(key.equals("showwh")) game.ShowWHs();
			else if(key.equals("playermove")) {
				Worker player = new Worker();
				player.Move(null, Direction.UP);
			} 
			//Palya valasztas es jatek inditas
			else if(key.equals("start")) {
				readWHs(); // ujra beolvassuk a fajlt, hogy az eredeti palyaallapotokat kapjuk vissza
				key = Szkeleton.kiir("?", "Valassz palyat! (0-2) ", "");
				Szkeleton.kiir("-", "currentWareHouse bellitva a megadott palyara ("+key+")", "");
				NewGame();
			}
			//Szkeleton.melyseg--;
			
			else if(key.equals("bos")) {
				Box box = new Box();
				Switch swi = new Switch();
				TrapDoor trapdoor = new TrapDoor();
				swi.SetTrapDoor(trapdoor);
				Szkeleton.kiir("-", "Eddig csak konstruktor hivasok.", "");
				swi.Accept(box, Direction.DOWN);
			}
			
			else if(key.equals("wos")) {
				Worker worker = new Worker();
				Switch swi = new Switch();
				TrapDoor trapdoor = new TrapDoor();
				swi.SetTrapDoor(trapdoor);
				Szkeleton.kiir("-", "Eddig csak konstruktor hivasok.", "");
				swi.Accept(worker, Direction.DOWN);
			}
			
			else if(key.equals("eot")) {
				Worker worker = new Worker();
				TrapDoor trapdoor = new TrapDoor();
				trapdoor.SetEntity(worker); // a worker a csapoajton all
				Switch swi = new Switch();
				swi.SetTrapDoor(trapdoor);
				swi.Accept(new Box(), Direction.DOWN);
			}
			
		} while(!key.equals("exit"));
		
	}
}
