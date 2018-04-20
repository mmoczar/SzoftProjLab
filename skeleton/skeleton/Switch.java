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
	public boolean Accept(Entity e, Direction d) throws IOException {
		return true;
	}
	
	// a csapoajto allapotanak az ellentettjere allitja
	public void SwitchTrap() throws IOException {
		if (trapdoor == null) {
			return;
		}
		trapdoor.SetState();
	}


	// Debug fuggveny
	public void Hi() {
		System.out.print("S");
	}
}
