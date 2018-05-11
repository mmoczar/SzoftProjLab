import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage; 
import javafx.scene.shape.Rectangle;

public class GUI extends Application implements Initializable  {

	
	//----- Status ------
	private List<StatusLabel> workerstatus;
	
	//----- Workers
	private List<Entity> workers;
	//----- Kirajzolhato objektumok
	private List<Drawable> drawables;
	//----- Aktualis wh
	private int cwh;
	

	//Az ablak ket oldala
	 @FXML private Pane gamePane;
	 @FXML private Pane statusPane;
	 
	 
	 
	 //FXML fajlban benne van hogy ez akkor hivodik meg ha lenyomnak egy billentyut
	 //AD-HOC megoldas eventhandlerrel kene
	 @FXML
	 public void Move(KeyEvent key) throws IOException {
		 
		if(workers != null) {
		 
		 switch(key.getCode()) {
		 //Worker 1
		 	case UP: workers.get(0).Move(null, Direction.LEFT, (Worker)workers.get(0)); break;
		 	case DOWN: workers.get(0).Move(null, Direction.RIGHT, (Worker)workers.get(0));break;
		 	case LEFT: workers.get(0).Move(null, Direction.UP, (Worker)workers.get(0));break;
		 	case RIGHT: workers.get(0).Move(null, Direction.DOWN, (Worker)workers.get(0));break;
		 	
		 //Worker 2
		 	case W: System.out.println("UP");break;
		 	case S: System.out.println("UP");break;
		 	case A: System.out.println("UP");break;
		 	case D: System.out.println("UP");break;
		 
		 //Worker 3
		 	case U: System.out.println("UP");break;
		 	case K: System.out.println("UP");break;
		 	case J: System.out.println("UP");break;
		 	case L: System.out.println("UP");break;
		default:
			break;
		 	
		 }
		onUpdate();
		updateStatus();
	 }
	 }
	
	 
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	//Inicializalas
	public void initGame() {
		
		//Eloszor lekerjuk a munkas listat
		workers = Game.getCurrentWH().getWorkers();
		//Utana a rajzolhato dolgoknak csinalunk egy listet
		drawables = new ArrayList<Drawable>();
		WareHouse wh = Game.getCurrentWH();
		
		
		//Vegigmegyunk a wh-n es minden tile-hoz letrehozzuk a megfelelo GTile-t
		for(int y = 1; y < Game.getCurrentWH().GetDimension().getX()-1; y++) {
			for(int x = 1; x < Game.getCurrentWH().GetDimension().getY()-1; x++) {
				Tile tile = wh.GetTileAt(new Vec2D(y,x));
				
				switch(tile.Hello()) {
				case"T": drawables.add(new GTile(tile));
				    break;
				case"H": drawables.add(new GHole(tile));	
					break;
				case"P": drawables.add(new GPillar(tile));	
				  	break;
				case"S": drawables.add(new GSwitch(tile));	
			  		break;
				case"D": drawables.add(new GTarget(tile));	
		  			break;
				case"C": drawables.add(new GTrapDoor(tile));	
	  				break;
				default: 
					System.out.print(tile.Hello());
					break;
				}
				
				
			}
		}
		//Boxok hozzadasa
		for(Entity b: Game.getCurrentWH().getBoxes()) {
			drawables.add(new GBox(b));
		}
		//Workerek hozza adasa a rajzolhato abjektumomk listajahoz
		for(Entity w: Game.getCurrentWH().getWorkers()) {
			drawables.add(new GWorker(w));
		}
		
		//A gamePane-nek adjuk az osszeset es igy mar ki lesz rajzolva
		gamePane.getChildren().addAll(drawables);
		
	}
	
	//Ujrarajzolas
	public void onUpdate() {
		for(Drawable dr: drawables) {
			dr.draw();
			//Ez majd kell a klyukralepeseknel
			//if(!dr.getAlive()) removeable.add(dr);
		}
	}
	
	// Uj jatek 
	public void newGame() throws IOException{
		
		Game.ClearGame();
		cwh = DialogBox.display("New Game", null);
		Game.NewGame(cwh);
		
		DialogBox.display("Worker Number", null);
		
		initGame();
		
		initStatus();
	}

	//------------------- Eredmeny jelzes-------------------------

	private void initStatus() {
		
		int numWork = Game.getCurrentWH().GetNumOfWorkers();
		workerstatus = new ArrayList<StatusLabel>();

		
		for(int i = 0; i < numWork; i++) {
			Worker act = (Worker) Game.getCurrentWH().getWorkers().get(i);
			workerstatus.add(new StatusLabel(act));
		}
		statusPane.getChildren().addAll(workerstatus);
	}
	
	private void updateStatus() {
		for(StatusLabel st: workerstatus) {
			st.update();
		}
	}

	
	// StatusLabel class az eredmenyekhez
	public class StatusLabel extends Label{
		private Worker worker;
		public StatusLabel(Worker w){
			super(w.getName() + " " + w.getScore());
			worker = w;
		}
		public void update() {
			super.setText(worker.getName() + " " + worker.getScore());
		}
	}
	
	//----------------------------------------------------------------------
	
   
} 