import java.io.IOException;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

/**
 * A lada grafikus megjeleniteset valositja meg.
 */
public class GBox extends Drawable{
	/**
	 * Az entitas, melyet megjelenit.
	 */
	private Entity ent;
	/**
	 * Az aktualis mezo, amelyen all.
	 */
	private Tile tile;
	/**
	 * A ladat reprezentalo kep.
	 */
	private Image img;

	/**
	 * Az osztaly konstruktora.
	 * @param e entitas
	 */
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
	
	/**
	 * Az munkas poziciojanak frissiteseert felelos.
	 */
	@Override
	public void draw() throws IOException {
		tile = ent.getTile();
		this.relocate((tile.pos().getX()-1)*100,(tile.pos().getY()-1)*100);
		ent.MovableCheck();

	}
	
	/**
	 * Visszaadja, hogy az entitas el-e.
	 * @return az entitas el-e
	 */
	@Override
	public boolean getAlive() {
		return ent.getAlive();
	}

}
