
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
	
	// A lada hat a kapcsolora
	@Override
	public boolean SwitchAction() {
		return true;
	}

	@Override
	public void Hi() {
		System.out.print("B");
		
	}

	@Override
	public void reduceNum() {
		Game.getCurrentWH().reduceNumOfBoxes();
		Game.getCurrentWH().reduceNumOfMovableBoxes();
	}
	public void SetTile(Tile t) {
		// TODO Auto-generated method stub
		
	}

}
