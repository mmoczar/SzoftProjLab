
public class Tile {
	protected Vec2D position;
	private Entity entity;
	
	public Tile(Vec2D pos) {
		position = pos;
	}
	
	public Tile(Vec2D pos, TrapDoor trap) {
		position = pos;
	}
	
	public void SetEntity(Entity e) {
		entity = e;
	}
	public void Accept(Entity e, Direction d) {
		
	}
	
	public void Remove(Entity e) {
		
	}
	
	public Entity GetEntityAt(Vec2D v) {
		return null;
		
	}
	 // Debug f�ggv�ny
	public void Hi() {
		System.out.print("O");
	}
	
	
}
