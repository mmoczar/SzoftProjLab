
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage; 


public class GUI extends Application implements Initializable  {

	
	//----- Status ------
	private List<StatusLabel> workerstatus;
	
	//----- Workers
	private List<Entity> workers;
	
	private Worker w1;
	private Worker w2;
	private Worker w3;
	
	
	//----- Kirajzolhato objektumok
	private List<Drawable> drawables;
	//----- Aktualis wh
	private int cwh;
	

	//Az ablak ket oldala
	 @FXML private Pane gamePane;
	 @FXML private Pane statusPane;
	 
	 //Label - footer
	 @FXML private Label right_status;
	 @FXML private Label left_status;
	 
	 //FXML fajlban benne van hogy ez akkor hivodik meg ha lenyomnak egy billentyut
	 //AD-HOC megoldas eventhandlerrel kene
	 @FXML
	 public void Move(KeyEvent key) throws IOException {
		 //System.out.println(w1);
		if(w1.getAlive()) {
		 
		 switch(key.getCode()) {
		 //Worker 1
		 	case UP: w1.Move(null, Direction.LEFT, w1); break;
		 	case DOWN: w1.Move(null, Direction.RIGHT, (Worker)w1);break;
		 	case LEFT: w1.Move(null, Direction.UP, (Worker)w1);break;
		 	case RIGHT: w1.Move(null, Direction.DOWN, (Worker)w1);break;
		default:
			break;
		 	
		 }
		
	 }
	if(w2 != null)
	{
		if(w2.getAlive()) {
			 
			 switch(key.getCode()) {
			 //Worker 1
			 	case W: w2.Move(null, Direction.LEFT, w2); break;
			 	case S: w2.Move(null, Direction.RIGHT, (Worker)w2);break;
			 	case A: w2.Move(null, Direction.UP, (Worker)w2);break;
			 	case D: w2.Move(null, Direction.DOWN, (Worker)w2);break;
			default:
				break;
			 	
			 }
			
		 }
	}
	
	if(w3 != null)
	{
		if(w3.getAlive()) {
			 
			 switch(key.getCode()) {
			 //Worker 1
			 	case U: w3.Move(null, Direction.LEFT, w3); break;
			 	case J: w3.Move(null, Direction.RIGHT, (Worker)w3);break;
			 	case H: w3.Move(null, Direction.UP, (Worker)w3);break;
			 	case K: w3.Move(null, Direction.DOWN, (Worker)w3);break;
			default:
				break;
			 	
			 }
			
		 }
	}	
		onUpdate();
		updateStatus();
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
	public void onUpdate() throws IOException {
		
		gamePane.getChildren().clear();
		if(Game.getCurrentWH().GetNumOfWorkers()==0
				|| !Game.getCurrentWH().hasMovableBox()) {
			gamePane.getChildren().add(new Label("Game Over"));
		}
		else {
		List<Drawable> removeable = new ArrayList<Drawable>();
	
		
		for(Drawable dr: drawables) {
			if(!dr.getAlive()) removeable.add(dr);
			else dr.draw();
			
		}
		
		for(Drawable rm: removeable) {
			drawables.remove(rm);
		}
		
		gamePane.getChildren().addAll(drawables);
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
		
		initWorkerEvent();
	}
	
	// Szabalyok kiirasa
	public void gameRule() throws IOException
	{
		DialogBox.display("Game Rule", null);
	}

	private void initWorkerEvent() {
		int l = workers.size();
		System.out.println(l);
		if(l >= 1) w1 = (Worker) workers.get(0);
		if(l >= 2) w2 = (Worker) workers.get(1);
		if(l >= 3) w3 = (Worker) workers.get(2);
		
	}


	//------------------- Eredmeny jelzes-------------------------

	private void initStatus() {
		
		statusPane.getChildren().clear();
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
			super(w.getName() + ": " + w.getScore());
			worker = w;
			
			this.setStyle("-fx-font-weight: bold;"
					+ "-fx-font-size: 30;");
		}
		public void update() {
			super.setText(worker.getName() + ": " + worker.getScore());
			if(!worker.getAlive())
			{
				this.setStyle("-fx-text-fill: red;"
						+ "-fx-font-weight: bold;"
						+ "-fx-font-size: 30;");
			}
		}
	}
	
	//----------------------------------------------------------------------
	
	public void quit() {
		System.exit(0);
	}
	
   
} 