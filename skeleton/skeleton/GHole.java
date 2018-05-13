import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class GHole extends Drawable {

	private Image img;

	public GHole(Tile tile){
		
		super((tile.pos().getX()-1)*100,(tile.pos().getY()-1)*100,100,100);
		img = new Image("file:hole.jpg");
		setFill(new ImagePattern(img));
		resize(100,100);

	}
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

}
