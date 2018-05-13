import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.StrokeType;


public class GTarget extends Drawable {
	private Image img;
	private Target target;
	public GTarget(Tile tile){
		
		super((tile.pos().getX()-1)*100,(tile.pos().getY()-1)*100,100,100);
		target = (Target) tile;
		img = new Image("file:target.png");
		setFill(new ImagePattern(img));
		setStroke(Color.web(target.getColorCode()));
		setStrokeType(StrokeType.INSIDE);
		setStrokeWidth(10);

	}
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

}
