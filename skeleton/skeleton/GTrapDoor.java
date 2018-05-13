import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;



public class GTrapDoor extends Drawable {
	private Tile tile;
	private Image img;

	public GTrapDoor(Tile tile){
		
		super((tile.pos().getX()-1)*100,(tile.pos().getY()-1)*100,100,100);
		this.tile = tile;
		img = new Image("file:trapdoor.png");
		setFill(new ImagePattern(img));
		resize(100,100);
	}

	@Override
	public void draw() {
		if(tile.getState()) {
			img = new Image("file:hole.jpg");
			setFill(new ImagePattern(img));
		}
		else {
			img = new Image("file:trapdoor.png");
			setFill(new ImagePattern(img));
		}
		
	}

}
