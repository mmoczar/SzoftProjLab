
public class Worker extends Entity {

	
	private int numOfPlacedBoxes;
	

	public Worker() {
	}

	public void SetTile(Tile t) {
		//Tile beallotsa
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
			else {
				System.out.println("Itt van valami");
				if(nb.MovedBy(e)) {
					System.out.println("El tudom tolni");
					nb.Move(this, d);
					tile.Accept(this, d);
				} 
				else System.out.println("Nem tudom tolni");
			} 
			
			return false;
				
		}
	

	@Override
	public boolean SwitchAction() {
		return true;
	}

	@Override
	public boolean MovedBy(Entity e) {
		
		if(e == null) return false;
		
		return true;
		
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
