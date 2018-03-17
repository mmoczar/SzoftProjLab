import java.io.IOException;

public class Tile {
	protected Vec2D position;
	protected Entity entity = null;
	
	protected Tile tUP;
	protected Tile tDOWN;
	protected Tile tLEFT;
	protected Tile tRIGHT;
	
	public Tile() throws IOException {
		Szkeleton.kiir(">", "Tile", "Tile()");
		Szkeleton.kiir("<", "Tile", "Tile()");
	}
	
	public Tile(TrapDoor trap) {
	}
	
	public void SetEntity(Entity e) throws IOException {
		Szkeleton.kiir(">", "Tile", "SetEntity(e)");
		entity = e;
		Szkeleton.kiir("<", "Tile", "SetEntity(e)");
	}
	
	//Szomszedos Tile keri ezt az Acceptet
	public boolean Accept(Entity e) throws IOException {
		entity = e;
		e.SetTile(this);
		System.out.println("Sikeres Mozgas"); // TODO ?? (bence)
		return false;
		
	}
	//Worker vagy Box keri ezt az Acceptet
	public void Accept(Entity e, Direction d) throws IOException { // TODO Ide nem kene mas fuggvenyhivas? (bence)

		Szkeleton.kiir(">", "Tile", "Accept(e,d)");
		Szkeleton.kiir("<", "Tile", "Accept(e,d)");

		
	}
	
	public void Remove(Entity e) throws IOException {
		Szkeleton.kiir(">", "Tile", "Remove(e)");
		Szkeleton.kiir("<", "Tile", "Remove(e)");
	}
	
	public void setNeighbor(Tile up, Tile down, Tile left, Tile right) {
		tUP = up;
		tDOWN = down;
		tLEFT = left;
		tRIGHT = right;
	}
	
	//Amikor mar egy masik Tile kerdezi
	public Entity GetEntityAt() throws IOException {
		Szkeleton.kiir(">", "Tile", "GetEntityAt()");
		Szkeleton.kiir("<", "Tile", "GetEntityAt()");
		return entity;
	}
	
	//Ez a fuggveny, amikor a worker kerdezi az alatta levo mezot, hogy mondja meg a szomszedon van-e Entity
	public Entity GetEntityAt(Direction d) throws IOException {
		Szkeleton.kiir(">", "Tile", "GetEntityAt(d)");
		switch(Szkeleton.kiir("?", "Mi van arra? (semmi, box, worker) ", "")) {
			case "semmi": Szkeleton.kiir("<", "Tile", "GetEntityAt(d)");
						  return null;
			case "box": Szkeleton.kiir("<", "Tile", "GetEntityAt(d)");
						return new Box();
			case "worker": Szkeleton.kiir("<", "Tile", "GetEntityAt(d)");
						   return new Worker();
		}
		return null;
		
	}
	 // Debug fuggveny
	public void Hi() {
		if(entity == null) System.out.print("O");
		else entity.Hi();
	}
	
	public Vec2D pos() {
		return position;
	}
	
}
