
public class Box extends Entity {
	
	private Target target;
	private Worker worker;
	
	
	@Override
	public boolean Move(Entity e, Direction d) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean MovedBy(Entity e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean SwitchAction() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void Hi() {
		System.out.println("B");
		
	}

}
