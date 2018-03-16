
public class Tile {
	protected Vec2D position;
	protected Entity entity = null;
	
	protected Tile UP;
	protected Tile DOWN;
	protected Tile LEFT;
	protected Tile RIGHT;
	
	public Tile() {
	}
	
	public Tile(TrapDoor trap) {
	}
	
	public void SetEntity(Entity e) {
		entity = e;
	}
	public void Accept(Entity e, Direction d) {
		
	}
	
	public void Remove(Entity e) {
		
	}
	
	public void setNeighbor(Tile up, Tile down, Tile left, Tile right) {
		UP = up;
		DOWN = down;
		LEFT = left;
		RIGHT = right;
	}
	
	//Amikor már egy másik Tile kérdezi
	public Entity GetEntityAt() {
		return entity;
	}
	
	//Eza függvény amikor a worker kérdezi az alatta lévő mezőt, hogy mondja meg a szomszédon van-e Entity
	public Entity GetEntityAt(Direction d) {
		switch(d) {
		case UP: return UP.GetEntityAt();
		case DOWN: return DOWN.GetEntityAt();
		case LEFT: return LEFT.GetEntityAt();
		case RIGHT: return RIGHT.GetEntityAt();
		default:
			break;
		}
		return null;
		
	}
	 // Debug fï¿½ggvï¿½ny
	public void Hi() {
		System.out.print("O");
	}
	
	public Vec2D pos() {
		return position;
	}
	
}
