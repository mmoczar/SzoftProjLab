import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;


public class GTarget extends Drawable {
	private Image img;
	
	public GTarget(Tile tile){
		
		super((tile.pos().getX()-1)*100,(tile.pos().getY()-1)*100,100,100);
		img = new Image("file:target.png");
		setFill(new ImagePattern(img));
		resize(100,100);

	}
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

}
