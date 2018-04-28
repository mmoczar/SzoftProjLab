import java.io.FileNotFoundException;
import java.io.IOException;

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
	
	public int height = 6;
	public int width = 6;
	int z = 100;
	private static Game game;
	
	private Pane root;
	
	
	private Image tile_img = new Image("file:tile.jpg");
	private Image box_img = new Image("file:box.png");
	private Image target_img = new Image("file:target.png");
	private Image hole_img = new Image("file:hole.jpg");
	private Image pillar_img = new Image("file:pillar.jpg");
	
	
	private Parent createContent() {
		root = new Pane();
		root.setPrefSize(600, 600);
		
		
		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
			
				if(Game.getCurrentWH().GetNumOfWorkers() == 0) this.stop();
				System.out.println(Game.getCurrentWH().GetNumOfBoxes());
				onUpdate();
			}	
		};
		
		timer.start();
		
		return root;
	}
	
	
	private void onUpdate() {
	    RePaint(Game.getCurrentWH().guiHandler());
	    //System.out.println(z);
		
	}
	
   @Override 
   public void start(Stage stage) throws FileNotFoundException, IOException, InterruptedException { 
	   
	   Worker w1 = new Worker("Mario",10);
	   Game.getCurrentWH().AddWorker(w1, 1, 2);
	   stage.setScene(new Scene(createContent()));
	   
	   stage.getScene().setOnKeyPressed(e -> {
		   try {
           if (e.getCode() == KeyCode.LEFT) {
				
				w1.Move(w1, Direction.LEFT, w1);
           } 
           else if (e.getCode() == KeyCode.RIGHT) {
				w1.Move(w1, Direction.RIGHT, w1);
          } 
           else if (e.getCode() == KeyCode.UP) {
				w1.Move(w1, Direction.UP, w1);
          }  
          
           else if (e.getCode() == KeyCode.DOWN) {
				w1.Move(w1, Direction.DOWN, w1);
          } 
	   		}
		   catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
       });
	   
	   
	  
	   stage.show();
	   
   }      
   public static void main(String args[]) throws FileNotFoundException, IOException{ 
	   game = new Game("game.txt");
	   
	   game.NewGame(0);
	   
      launch(args); 
   } 
   
   public void RePaint(String s) {
	   
	   int x = 0;
	   int y = 0;
	   int k = 0;
	   
	  
	   root.getChildren().clear();
	   //System.out.println(s);
	   
	   for(int i= 0; i<height; i++) {
			for(int j = 0; j<width; j++) {
				Rectangle rectangle = new Rectangle(100,100);
				rectangle.relocate(x,y);  
			      
			      
			      switch(s.charAt(k)) {
			      case'H': 
			    	  rectangle.setFill(new ImagePattern(hole_img));
			    	  break;
			      case'D': 
			    	  rectangle.setFill(new ImagePattern(target_img));
			    	  break;
			      case'S': 
			    	  rectangle.setFill(Color.YELLOW);
			    	  break;
			      case'C': 
			    	  rectangle.setFill(Color.ORANGE);
			    	  break;
			      case'P': 
			    	  rectangle.setFill(new ImagePattern(pillar_img));
			    	  break;
			      case'B': 
			    	  rectangle.setFill(new ImagePattern(box_img));
			    	  break;
			      case'W': 
			    	  rectangle.setFill(Color.BLUE);
			    	  break;
			      case'T': 
			    	  
			    	  rectangle.setFill(new ImagePattern(tile_img));
			    	  break;
			      default:
			    	  
			    	  break;
			      }
			      
			      rectangle.setStroke(Color.BLACK);
			      x += size;
			      k++;
			      root.getChildren().add(rectangle);
			}
			
			y += size;
			x = 0;
		}
   }
   
   
} 