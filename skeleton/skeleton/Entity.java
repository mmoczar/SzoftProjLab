
public abstract class Entity {
	protected Tile tile;
	
	public abstract void SetTile(Tile t);
	
	public abstract boolean Move (Entity e, Direction d);
	
	public abstract boolean MovedBy(Entity e);
	
	public abstract boolean SwitchAction();
	
	//debug
	
	public abstract void Hi();
}
