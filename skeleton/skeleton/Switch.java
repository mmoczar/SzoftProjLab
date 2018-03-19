import java.io.IOException;

/**
 * A csapóajtókat állító mező
 */
public class Switch extends Tile {
	
	// kapcsolohoz tartozo csapoajto
	private TrapDoor trapdoor;

	// Default konstruktor
	public Switch() throws IOException {
		Szkeleton.kiir(">", "Switch", "Switch()");	
		Szkeleton.kiir("<", "Switch", "Switch()");	
	}

	// A csapóajtó beállitása
	public void SetTrapDoor(TrapDoor td) {
		trapdoor = td;
	}
	
	// entitas tipsatol fuggoen megvaltoztatja a csapoajto allapotat
	public void Accept(Entity e, Direction d) throws IOException {
		Szkeleton.kiir(">", "Switch", "Accept(e,d)");
		if(e.SwitchAction()) SwitchTrap();
		Szkeleton.kiir("<", "Switch", "Accept(e,d)");
	}
	
	// a csapoajto allapotanak az ellentettjere allitja
	public void SwitchTrap() throws IOException {
		Szkeleton.kiir(">", "Switch", "SwitchTrap");
		trapdoor.SetState();
		// trapdoor.GetState(): true ha nyitva
		if(trapdoor.GetState() && trapdoor.entity != null) trapdoor.DropEntity(trapdoor.GetEntityAt()); // ha a csapoajto nyitva es allnak rajta, leejti
		Szkeleton.kiir("<", "Switch", "SwitchTrap()");
	}


	// Debug fuggveny
	public void Hi() {
		System.out.print("S");
	}
}
