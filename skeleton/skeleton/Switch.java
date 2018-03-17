import java.io.IOException;

public class Switch extends Tile {
	
	// kapcsolohoz tartozo csapoajto
	private TrapDoor trapdoor;
	
	public Switch() throws IOException {
		Szkeleton.kiir(">", "Switch", "Switch()");	
		Szkeleton.kiir("<", "Switch", "Switch()");	
	}
	
	public void SetTrapDoor(TrapDoor td) {
		trapdoor = td;
	}
	
	// entitas tipsatol fuggoen megvaltoztatja a csapoajto allapotat
	public void Accept(Entity e, Direction d) throws IOException {
		if(e.SwitchAction()) SwitchTrap();
	}
	
	// a csapoajto allapotanak az ellentettjere allitja
	public void SwitchTrap() throws IOException {
		Szkeleton.kiir(">", "Switch", "SwitchTrap");
		trapdoor.SetState(!trapdoor.GetState());
		Szkeleton.kiir("<", "Switch", "SwitchTrap()");
	}
	
	public void setNeighbor(Tile up, Tile down, Tile left, Tile right) {
		tUP = up;
		tDOWN = down;
		tLEFT = left;
		tRIGHT = right;
	}

	public void Hi() {
		System.out.print("S");
	}
}
