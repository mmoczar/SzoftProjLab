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

=======
>>>>>>> 30dc4f77aa2baa32023f61ff731bbeffeefbc3d1
	
	/**
	 * Az osztaly konstruktora.
	 * @param tile a mezo, ahol van
	 */
<<<<<<< HEAD

	private Target target;

=======
	private Target target;

	/**
	 * Az osztaly konstruktora.
	 * @param tile a mezo, ahol van
	 */
>>>>>>> 30dc4f77aa2baa32023f61ff731bbeffeefbc3d1
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
