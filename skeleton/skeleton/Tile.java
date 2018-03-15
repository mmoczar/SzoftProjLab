
public class Tile {
	protected Vec2D position;
	private Entity entity;
	
	public Tile(Vec2D pos) {
		position = pos;
	}
	
	public void Accept(Entity e, Direction d) {
		
	}
	
	public void Remove(Entity e) {
		
	}
	
	public Entity GetEntityAt(Vec2D v) {
		return null;
		
	}
	 // Debug függvény
	public void Hi() {
		System.out.print("O");
	}
	
	
}
