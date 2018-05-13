import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

/**
 * A mezo grafikus megjeleniteset valositja meg.
 */
public class GTile extends Drawable{
	/**
	 * A mezot reprezentalo kep.
	 */
	private Image img;
	
	/**
	 * Az osztaly konstruktora.
	 * @param tile a mezo, ahol van
	 */
	public GTile(Tile tile){
		
		super((tile.pos().getX()-1)*100,(tile.pos().getY()-1)*100,100,100);
		img = new Image("file:tile.jpg");
		setFill(new ImagePattern(img));
		resize(100,100);

	}
	
	
}
