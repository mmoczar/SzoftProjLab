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
		System.out.println("Sikeres Mozgás");
		return false;
		
	}
	//Worker vagy Box keri ezt az Acceptet
	public void Accept(Entity e, Direction d) throws IOException {
<<<<<<< HEAD
		//oszlop figyelese
		boolean isPillar = false;
=======
		Szkeleton.kiir(">", "Tile", "Accept(e,d)");
		Szkeleton.kiir("<", "Tile", "Accept(e,d)");
>>>>>>> 4de1573706b208ca41ca2c5a4416cd85ab11aec0
		
	}
	
	public void Remove(Entity e) {
		
	}
	
	public void setNeighbor(Tile up, Tile down, Tile left, Tile right) {
		tUP = up;
		tDOWN = down;
		tLEFT = left;
		tRIGHT = right;
	}
	
	//Amikor mar egy masik Tile kerdezi
	public Entity GetEntityAt() {
		return entity;
	}
	
	//Ez a fuggveny, amikor a worker kerdezi az alatta levo mezot, hogy mondja meg a szomszedon van-e Entity
	public Entity GetEntityAt(Direction d) throws IOException {
		Szkeleton.kiir(">", "Tile", "GetEntityAt(d)");
		switch(Szkeleton.kiir("?", "", "")) {
		case"null": Szkeleton.kiir("<", "Tile", "GetEntityAt(d)"); return null;
		case"box": Szkeleton.kiir("<", "Tile", "GetEntityAt(d)");   return new Box();
		case"worker": Szkeleton.kiir("<", "Tile", "GetEntityAt(d)"); return new Worker();
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
