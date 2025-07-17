package InterEx;

public class RepairableMain {

	public static void main(String[] args) {
		Tank tank = new Tank ();
		DropShip dropship = new DropShip();
		
		Marine marine = new Marine();
		SCV scv = new SCV ();
		
		scv.repair(tank); // scv가 tank를 수리한다
		scv.repair(dropship); // dropship가 tank를 수리한다
	}
}
