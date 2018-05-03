import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage; 
import javafx.scene.shape.Rectangle;

public class GUI extends Application { 
	
	public int size = 100;
	public int height = 7;
	public int width = 7;
	int z = 100;
	private static Game game;
	private List<Drawable> drawables;
	
	
	

	private Scene gameScene;
	private Group root;
	
	private Image tile_img = new Image("file:tile.jpg");
	private Image box_img = new Image("file:box.png");
	private Image target_img = new Image("file:target.png");
	private Image hole_img = new Image("file:hole.jpg");
	private Image pillar_img = new Image("file:pillar.jpg");
	
	
	private void createContent() {
		
		root = new Group();
        gameScene = new Scene(root, 600, 600, Color.BLACK);
		
		
		drawables = new ArrayList<Drawable>();
		WareHouse wh = Game.getCurrentWH();
		
		for(int y = 1; y < width; y++) {
			for(int x = 1; x < height; x++) {
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
		
		for(Entity b: Game.getCurrentWH().getBoxes()) {
			drawables.add(new GBox(b));
		}
		
		for(Entity w: Game.getCurrentWH().getWorkers()) {
			drawables.add(new GWorker(w));
		}
		
	}	
	
	
	private void onUpdate(Stage stage) {
		
		List<Drawable> removeable = new ArrayList<Drawable>();
		
		root.getChildren().clear();
		
		
		
		
		for(Drawable dr: drawables) {
			dr.draw();
			if(!dr.getAlive()) removeable.add(dr);
		}
		
		for(Drawable rm: removeable) {
			drawables.remove(rm);
		}
		
		root.getChildren().addAll(drawables);
		
	}
	
   @Override 
   public void start(Stage stage) throws FileNotFoundException, IOException, InterruptedException { 
	   
	   Worker w1 = new Worker("Mario",10);
	   Game.getCurrentWH().AddWorker(w1, 1, 2);
	   createContent();
	   stage.setScene(gameScene);
	   onUpdate(stage);
	   stage.show();
	   gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
		   
           @Override
           public void handle(KeyEvent event) {
        	   try {
               switch (event.getCode()) {
                   case UP: w1.Move(w1, Direction.LEFT, w1);  System.out.println("asd");break;
                   case DOWN: w1.Move(w1, Direction.RIGHT, w1); break;
                   case LEFT:  w1.Move(w1, Direction.UP, w1); break;
                   case RIGHT: w1.Move(w1, Direction.DOWN, w1); break;
                   case SHIFT: //running = true; break;
                	   
                	   
               }
               onUpdate(stage);
        	   }
        	   catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
           }
       });
	   
	   
	  
	   stage.show();
	   
   }      
   public static void main(String args[]) throws FileNotFoundException, IOException{ 
	   game = new Game("game.txt");
	   
	   game.NewGame(0);
	   
	   launch(args); 
   } 
   
   
   
   
} 