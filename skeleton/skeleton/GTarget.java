import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

/**
 * A celmezo grafikus megjeleniteset valositja meg.
 */
public class GTarget extends Drawable {
	/**
	 * A celmezot reprezentalo kep.
	 */
	private Image img;
	
	/**
	 * Az osztaly konstruktora.
	 * @param tile a mezo, ahol van
	 */
	public GTarget(Tile tile){
		
		super((tile.pos().getX()-1)*100,(tile.pos().getY()-1)*100,100,100);
		img = new Image("file:target.png");
		setFill(new ImagePattern(img));
		resize(100,100);

	}
	

}
