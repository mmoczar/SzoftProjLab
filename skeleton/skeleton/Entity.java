import java.io.IOException;

public abstract class Entity {
	protected Tile tile;
	
	public abstract void SetTile(Tile t);
	
	public abstract boolean Move (Entity e, Direction d) throws IOException;
	
	public abstract boolean MovedBy(Entity e);
	
	public abstract boolean SwitchAction();
	
	public abstract void reduceNum();
	
	//debug
	
	public abstract void Hi();
}
