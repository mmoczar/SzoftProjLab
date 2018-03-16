
public class Switch extends Tile {

	private TrapDoor hole;
	
	public Switch(Vec2D pos) {
		super(pos);
	}
	
	public Switch(Vec2D pos, TrapDoor trap) {
		super(pos);
		hole = trap;
	}

	public void Hi() {
		System.out.print("S");
	}
}
