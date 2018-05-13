import java.io.IOException;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;


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
		resize(100,100);
		//System.out.println(tile.pos().getX());
		
		//setStroke(Color.BLACK);
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
