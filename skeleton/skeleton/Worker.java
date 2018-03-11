
public class Worker extends Entity {

	
	private int numOfPlacedBoxes;
	
	
	@Override
	public boolean Move(Entity e, Direction d) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean MovedBy(Box b) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean MovedBy(Worker w) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean SwitchAction() {
		return true;
	}

	@Override
	public boolean MovedBy(Entity e) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void Die() {
		
	}
	
	public void AddPlacedBox() {
		numOfPlacedBoxes++;
	}
	

}
