import java.io.IOException;


/**
 * Az oszlopokat reprezentáló osztály
 */
public class Pillar extends Tile {
	
	// Default konstruktor
	public Pillar() throws IOException {
		Szkeleton.kiir(">", "Pillar", "Pillar()");
		Szkeleton.kiir("<", "Pillar", "Pillar()");
	}

	//oszlop acceptje
	public boolean Accept(Entity e) throws IOException {
		Szkeleton.kiir(">", "Pillar", "Accept(e)");
		//Megivja a nekiszalado entity-re a ToPillar fuggvenyet
		if(e.ToPillar()) {
			Szkeleton.kiir("<", "Pillar", "Accept(e): true");
			return true;
		}
		Szkeleton.kiir("<", "Pillar", "Accept(e): false");
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
