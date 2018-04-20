import java.io.IOException;


/**
 * Az oszlopokat reprezentáló osztály
 */
public class Pillar extends Tile {
	
	// Default konstruktor
	public Pillar() throws IOException {

	}

	//oszlop acceptje
	public boolean Accept(Entity e) throws IOException {

		return false;
	}

	/*
	public boolean WorkerToPillar(Worker w) throws IOException {
		Szkeleton.kiir(">", "Pillar", "Accept()");
		System.out.println("Ezt a playert fel kell kanalazni");
		Szkeleton.kiir("<", "Pillar", "Accept(): true");
		return true;
	}*/

	// Nem tartózkodhaz rajta enitity
	public Entity GetEntityAt() {
		return null;
	}
	
	// Debug fuggveny
	public void Hi() {
		System.out.print("X");
	}
}
