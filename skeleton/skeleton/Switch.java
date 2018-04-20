import java.io.IOException;

/**
 * A csapóajtókat állító mező
 */
public class Switch extends Tile {
	
	// kapcsolohoz tartozo csapoajto
	private TrapDoor trapdoor;

	// Default konstruktor
	public Switch(TrapDoor recent) throws IOException {
		trapdoor = recent;
	}

	// A csapóajtó beállitása
	public void SetTrapDoor(TrapDoor td) {
		trapdoor = td;
	}
	
	// entitas tipsatol fuggoen megvaltoztatja a csapoajto allapotat
	public void Accept(Entity e, Direction d) throws IOException {

	}
	
	// a csapoajto allapotanak az ellentettjere allitja
	public void SwitchTrap() throws IOException {

	}


	// Debug fuggveny
	public void Hi() {
		System.out.print("S");
	}
}
