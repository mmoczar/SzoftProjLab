import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Tester {
	
	public ArrayList<String> test_in = new ArrayList<String>();
	public ArrayList<String> test_out = new ArrayList<String>();
	public ArrayList<String> test_result = new ArrayList<String>();
	public ArrayList<Worker> test_workers = new ArrayList<Worker>();
	
	public void test_in(String file) throws FileNotFoundException, IOException {
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    
		    //Elso sor beolvasasa, ami egy szam és megmutatja hany raktar lesz
		    while ((line = br.readLine()) != null) {
		    		
		    		boolean flag = false;
		    		if(line.equals("+")) {
		    			flag = true;
		    		}
		    		else if(!flag) {
		    			
		    			test_in.add(line);
		    		}
		    		else if(flag) {
		    			test_out.add(line);
		    		}
		    		
		    }
		}
	
	}
	
	public void test_run() throws FileNotFoundException, IOException {
		Game game = new Game("game.txt");
		
		String[] temp;
		
		
		
		for(int i = 0; i < test_in.size(); i++) {
			
			temp = test_in.get(i).split(" ");
			
			switch(temp[0]) {
				case"loadWH":
					game.NewGame(Integer.parseInt(temp[1])-1);
					//System.out.println("Sikeres load");
					break;
				case"placeWorker":
					Worker w = null;
					w = new Worker("W"+temp[1],1);
					Game.getCurrentWH().AddWorker(w, Integer.parseInt(temp[2]), Integer.parseInt(temp[3]));
					test_workers.add(w);
					break;
				case"moveWorker":
					Direction d = null;
					switch(temp[2]) {
						case"up": d = Direction.UP; break;
						case"down": d = Direction.DOWN; break;
						case"left": d = Direction.LEFT; break;
						case"right": d = Direction.RIGHT; break;
					}
					
					
					Worker w1 = test_workers.get(0);
					if(w1.Move(null, d, w1)) {
						test_result.add("Sikeres mozgas, sebesseg: 1");
						System.out.println("+");
					}
					else {
						test_result.add("Sikertelen mozgas");
						
					}
					
					break;
				case"listEntities":
					WareHouse wh = Game.getCurrentWH();
					
					for(int x = 0; x < wh.GetDimension().getX(); x++)
						for(int y = 0; y < wh.GetDimension().getY(); y++) {
							Tile t = wh.GetTileAt(new Vec2D(x,y));
							if(t.GetEntityAt() != null) {
								String s = x + " " + y + " " + t.GetEntityAt().Hello();
								test_result.add(s);
								
							}
						}
					break;
				
			}
			
			
			
			
			
		}
	}
	
	public boolean test_validate() {
		//test_result.remove(0);
		if(test_out.size() != test_result.size()) return false;
		for(int i = 0; i< test_out.size(); i++) {
			for(int j = 0; j < test_result.size(); j++) {
				if(!test_out.get(i).equals(test_result.get(j)));
					return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Tester test = new Tester();
		test.test_in("1.test");
		test.test_run();
		if(test.test_validate()) System.out.println("OK");
		else System.out.println("NO");

	}

}
