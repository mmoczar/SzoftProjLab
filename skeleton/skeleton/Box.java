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
			
			//this.MovableCheck();
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


	public boolean MovableCheck() throws IOException {
		//Ha mar tudjuk, hogy nem tud mozogni, nem kell csinálni semmit.

		// lekerdezzuk a szomszedos tileokat
		Tile tUP = tile.GetNbTile(Direction.UP);
		Tile tDOWN = tile.GetNbTile(Direction.DOWN);
		Tile tLEFT = tile.GetNbTile(Direction.LEFT);
		Tile tRIGHT = tile.GetNbTile(Direction.RIGHT);

		boolean up,down,left,right;
		up = !tUP.Accept(Direction.UP);
		down = !tDOWN.Accept(Direction.DOWN);
		left = !tLEFT.Accept(Direction.LEFT);
		right = !tRIGHT.Accept(Direction.RIGHT);
		
		System.out.println(up +" " + down + " "+ left + ""+ right + " ");
		
		//sarokban vagyunk?
		if ((up && right) || (up && left) || (down && right) || (down && left)) {
			canMove = false;
			Game.getCurrentWH().reduceNumOfMovableBoxes();
			System.out.println("sarokban");
			return false;
		}
		
		return true;
	}

	public boolean getCanMove() {
		return canMove;
	}

}
