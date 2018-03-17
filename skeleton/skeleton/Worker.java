
public class Worker extends Entity {

	
	private int numOfPlacedBoxes;
	

	public Worker() {
	}

	public void SetTile(Tile t) {
		//Tile beállítása
		tile = t;
	}
	
	//Worker mozgatasa
	@Override
	public boolean Move(Entity e, Direction d) {
			//Ellenorzi hogy az adott iranyban van-e valaki
			Entity nb = tile.GetEntityAt(d); 
			if(nb == null){
				System.out.println("Mellttem nincs semmi");
				tile.Accept(this, d);
			}
			else System.out.println("Itt van valami");
			
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
	
	
	public void Hi() {
		System.out.print("W");
	}
}
