
public abstract class Entity {
	protected Tile tile;
	
	public abstract boolean Move (Entity e, Direction d);
	
	public abstract boolean MovedBy(Entity e);
	
	public abstract boolean SwitchAction();
	
	public abstract void reduceNum();
	
	//debug
	
	public abstract void Hi();
}
