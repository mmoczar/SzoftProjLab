import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.StrokeType;

/**
 * A celmezo grafikus megjeleniteset valositja meg.
 */
public class GTarget extends Drawable {
	/**
	 * A celmezot reprezentalo kep.
	 */
	private Image img;
<<<<<<< HEAD
	
	/**
	 * Az osztaly konstruktora.
	 * @param tile a mezo, ahol van
	 */
=======
	private Target target;
>>>>>>> 3bbdaafb1fdbbcbe182f5a12ebfbafae5b053782
	public GTarget(Tile tile){
		
		super((tile.pos().getX()-1)*100,(tile.pos().getY()-1)*100,100,100);
		target = (Target) tile;
		img = new Image("file:target.png");
		setFill(new ImagePattern(img));
		setStroke(Color.web(target.getColorCode()));
		setStrokeType(StrokeType.INSIDE);
		setStrokeWidth(10);

	}
	

}
