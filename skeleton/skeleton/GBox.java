import java.io.IOException;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.StrokeType;


public class GBox extends Drawable{

	private Entity ent;
	private Tile tile;
	private Image img;

	
	public GBox(Entity e){
		super((e.getTile().pos().getX()-1)*100,(e.getTile().pos().getY()-1)*100,100,100);
		ent = e;
		tile = e.getTile();

		img = new Image("file:box.png");
		setFill(new ImagePattern(img));
		
		setStroke(Color.web(ent.getTarget().getColorCode()));
		setStrokeType(StrokeType.INSIDE);
		setStrokeWidth(2);
	}
	@Override
	public void draw() throws IOException {
		tile = ent.getTile();
		this.relocate((tile.pos().getX()-1)*100,(tile.pos().getY()-1)*100);
		ent.MovableCheck();

	}
	
	@Override
	public boolean getAlive() {
		return ent.getAlive();
	}

}
