import java.io.IOException;
import java.util.ArrayList;

/**
 * Ladat reprezentalo osztaly.
 */
public class Box extends Entity {


	boolean canMove = true;
	private ArrayList<Box> visited = new ArrayList<>();

	/**
	 * A ladahoz tartozo celmezo.
	 */
	private Target target;
	/**
	 * A tolast megkezdo munkas.
	 */
	private Tile tile;
	


	// Doboz mozog
	/**
	 * Adott iranyba lep egyet, ha sikerult lepni, akkor igazzal, ha nem sikerult lepni, akkor hamissal ter vissza.
	 * @param e entitas
	 * @param d irany
	 * @return sikerult-e elmozogni
	 */
	@Override
	public boolean Move(Entity e, Direction d, Worker w) throws IOException {
		Tile temp = tile;
		
		if(w.getPower() != 0 && temp.GetNbTile(d).Accept(this, d, w)){

			//System.out.println("Sikeres mozgas");
			double res;

			switch (tile.getRes()) {
				case REGULAR:
					res = 1;
					break;
				case OIL:
					res = 0.5;
					break;
				case HONEY:
					res = 2;
					break;
					default:
						res = 1;
			}
			w.setPower(w.getPower() - res);

			temp.Remove(/*this*/);
			
			//TODO movable boxok kezel�se
			this.MovableCheck();
			System.out.println("move: " + canMove);
			
			return true;
		}
		else {

			return false;
		} 
	}
	
	

	// Dobozt elmozgatjak
	/**
	 * Visszaadja, hogy el tudtak-e tolni.
	 * @param e entitas, mely tolja
	 * @return el tudtak-e tolni
	 */
	@Override
	public boolean MovedBy(Entity e) throws IOException {

		return true;
	}
	
	// A lada hat a kapcsolora
	/**
	 * A lada hatassal van a kapcsolora, igazzal ter vissza.
	 * @return hatassal van-e a kapcsolora
	 */
	@Override
	public boolean SwitchAction() throws IOException {

		return true;
	}

	// Debug fv
	@Override
	public void Hi() {
		System.out.print("B");
	}

	public String Hello() {
		return "B";
	}
	
	// Doboz eltünésekor
	@Override
	public void reduceNum() throws IOException {

		//TODO: WTF

	}
	
	
	
	// Tile beállítása
	/**
	 * Beallitja azt a mezot, amelyiken a lada van.
	 * @param t beallitando mezo
	 */
	public void SetTile(Tile t) {
		tile = t;	
	}

	// Oszlopnak ütközik
	/**
	 * Oszlopnak utkozik.
	 * @return hamis
	 */
	@Override
	public boolean ToPillar() {
		return false;
	}

	@Override
	public Target getTarget(){
		return target;
	}
	
	public void setTarget(Target t){
		target = t;
	}

	
	public void Die() {
		try {
			super.Die();
			Game.getCurrentWH().reduceNumOfBoxes();
			Game.getCurrentWH().RemoveBox(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Tile getTile() {
		return tile;
	}


	public boolean CanMove() {
		try {
			MovableCheck();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("b: " + canMove);
		return canMove;
	}

	public void MovableCheck() throws IOException {
		//Ha mar tudjuk, hogy nem tud mozogni, nem kell csinálni semmit.
		if (!canMove)
			return;

		// lekerdezzuk a szomszedos tileokat
		Tile tUP = tile.GetNbTile(Direction.UP);
		Tile tDOWN = tile.GetNbTile(Direction.DOWN);
		Tile tLEFT = tile.GetNbTile(Direction.LEFT);
		Tile tRIGHT = tile.GetNbTile(Direction.RIGHT);

		//sarokban vagyunk?
		if ((tUP.Hello().equals("P") && (tRIGHT.Hello().equals("P"))) ||
				(tUP.Hello().equals("P") && (tLEFT.Hello().equals("P"))) ||
				(tDOWN.Hello().equals("P") && (tRIGHT.Hello().equals("P"))) ||
				((tDOWN.Hello().equals("P")) && (tLEFT.Hello().equals("P")))
				) {
			canMove = false;
			Game.getCurrentWH().reduceNumOfMovableBoxes();
			System.out.println("sarokban");
			return;
		}

		//lekerdezzuk a szomszedos entityket is.
		Entity eUP = tile.GetEntityAt(Direction.UP);
		Entity eDOWN = tile.GetEntityAt(Direction.DOWN);
		Entity eLEFT = tile.GetEntityAt(Direction.LEFT);
		Entity eRIGHT = tile.GetEntityAt(Direction.RIGHT);


		boolean bUP = true, bDOWN = true, bLEFT = true, bRIGHT = true;

		//ha box van a szomszedban, megkerdezzuk tole, o tud e mozogni. (itt a rekurzio :) )

		if (eUP != null) {
			if (eUP.Hello().equals("B")) {
				visited.add((Box)eUP);
				bUP = ((Box)eUP).CanMove();
			}
		}
		if (eDOWN != null) {
			if (eDOWN.Hello().equals("B")) bDOWN = ((Box) eDOWN).CanMove();
		}
		if (eLEFT != null) {
			if (eLEFT.Hello().equals("B")) bLEFT = ((Box)eLEFT).CanMove();
		}
		if (eRIGHT != null) {
			if (eRIGHT.Hello().equals("B")) bRIGHT = ((Box)eRIGHT).CanMove();
		}

		//ha semerre sem tudunk mozogni, akkor csokkentunk.
		if(!bUP && !bDOWN && !bLEFT && !bRIGHT) {
			canMove = false;
			Game.getCurrentWH().reduceNumOfMovableBoxes();
			return;
		}
	}


}
