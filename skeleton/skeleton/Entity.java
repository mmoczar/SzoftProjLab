import java.io.IOException;

public abstract class Entity {
	protected Tile tile;
	
	public abstract void SetTile(Tile t) throws IOException;
	
	public abstract boolean Move (Entity e, Direction d) throws IOException;
	
	public abstract boolean MovedBy(Entity e) throws IOException;
	
	public abstract boolean SwitchAction() throws IOException;
	
	public abstract void reduceNum() throws IOException;
	
	//debug
	
	public abstract void Hi();

	public abstract boolean ToPillar() throws IOException;
}
