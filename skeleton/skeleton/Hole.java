import java.io.IOException;


/**
 * Az entity-ket elnyelo Tile
 */
public class Hole extends Tile {

	/**
	 * Default konstruktor
	 * @throws IOException
	 */
	public Hole() throws IOException {

	}

	// A Hole-ra erkezo entity-ket kezeli

	/**
	 * Kezei a lyukra érkezni akaró entityket
	 * @param e	az entity
	 * @return	ide mozoghat-e az entity
	 * @throws IOException
	 */
	public boolean Accept(Entity e) throws IOException {

		return false;
		
	}

	/**
	 * debug fv
	 */
	public void Hi() {
		System.out.print("H");
	}
}
