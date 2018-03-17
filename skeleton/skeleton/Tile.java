
public class Tile {
	protected Vec2D position;
	protected Entity entity = null;
	
	protected Tile tUP;
	protected Tile tDOWN;
	protected Tile tLEFT;
	protected Tile tRIGHT;
	
	public Tile() {
	}
	
	public Tile(TrapDoor trap) {
	}
	
	public void SetEntity(Entity e) {
		entity = e;
	}
	
	//Szomszedos Tile keri ezt az Acceptet
	public boolean Accept(Entity e) {
		entity = e;
		System.out.println("Sikeres Mozgás");
		return false;
		
	}
	//Worker vagy Box kéri ezt az Acceptet
	public void Accept(Entity e, Direction d) {
		//oszlop figyelése
		boolean isPillar = false;
		
		//Mozgas iranyaba elfogadat kerni
		switch(d) {
		case UP: isPillar = tUP.Accept(e); break;
		case DOWN: isPillar = tDOWN.Accept(e); break;
		case LEFT: isPillar = tLEFT.Accept(e); break;
		case RIGHT: isPillar = tRIGHT.Accept(e); break;
		default:
			break;
		}
		
		//kitorolni az elmozgott entity referenciajat
		if(!isPillar) entity = null;
	}
	
	public void Remove(Entity e) {
		
	}
	
	public void setNeighbor(Tile up, Tile down, Tile left, Tile right) {
		tUP = up;
		tDOWN = down;
		tLEFT = left;
		tRIGHT = right;
	}
	
	//Amikor már egy másik Tile kérdezi
	public Entity GetEntityAt() {
		return entity;
	}
	
	//Eza függvény amikor a worker kérdezi az alatta lévő mezőt, hogy mondja meg a szomszédon van-e Entity
	public Entity GetEntityAt(Direction d) {
		switch(d) {
		case UP: return tUP.GetEntityAt(); 
		case DOWN: return tDOWN.GetEntityAt(); 
		case LEFT: return tLEFT.GetEntityAt(); 
		case RIGHT: return tRIGHT.GetEntityAt();
		default:
			break;
		}
		return null;
		
	}
	 // Debug fï¿½ggvï¿½ny
	public void Hi() {
		if(entity == null) System.out.print("O");
		else entity.Hi();
	}
	
	public Vec2D pos() {
		return position;
	}
	
}
