import java.awt.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Game {
	private WareHouse currentWarehouse;
	private WareHouse[] warehouses;
	
	public Game(String file) throws FileNotFoundException, IOException {
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    
		    //Első sor beolvasása, ami egy szám és megmutatja hány raktár lesz
		    line = br.readLine();
		    //Generikus tömb létrahozása a megfelelő számra
		    warehouses = (WareHouse[]) Array.newInstance(WareHouse.class, Integer.parseInt(line));
		    
		    //Mapok beolvasása fájlból ha, új map akkor a fáljban azt egy + jelzi
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
			warehouses[i].draw();
		}
	}
	
	public void NewGame(WareHouse wh) {
		
	}
	
	public void EndGame() {
		
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Game game = new Game("game.txt");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String key = null;
		do {
			System.out.println("Show Warehouses (showwh)");
			System.out.println("Exit (exit)");
			
			key = br.readLine();
			
			if(key.equals("showwh")) game.ShowWHs();
			
			
		}while(!key.equals("exit"));
		
	}
}
