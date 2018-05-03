import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class GBox extends Drawable{

	private Entity ent;
	private Tile tile;
	private Image img;
	private int z_index;
	
	public GBox(Entity e){
		super((e.getTile().pos().getX()-1)*100,(e.getTile().pos().getY()-1)*100,100,100);
		ent = e;
		tile = e.getTile();
		z_index = 2;
		img = new Image("file:box.png");
		setFill(new ImagePattern(img));
		resize(100,100);
		//System.out.println(tile.pos().getX());
		
		//setStroke(Color.BLACK);
	}
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

}
