
public abstract class Entity {
	private Tile tile;
	
	public abstract boolean Move (Entity e, Direction d);
	
	public abstract boolean MovedBy(Entity e);
	
	public abstract boolean SwitchAction();
}
