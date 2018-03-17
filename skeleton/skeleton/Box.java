
public class Box extends Entity {
	
	private Target target;
	private Worker worker;
	
	
	@Override
	public boolean Move(Entity e, Direction d) {
		System.out.println("Move - Box");
		return true;
	}

	@Override
	public boolean MovedBy(Entity e) {
		return true;
	}

	@Override
	public boolean SwitchAction() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void Hi() {
		System.out.print("B");
		
	}

	@Override
	public void SetTile(Tile t) {
		// TODO Auto-generated method stub
		
	}

}
