package InterEx;

public class DropShip extends AirUnit implements InterfaceRepair {

	public DropShip() { // 125
		super (125);
		hitPoint = MAX_HP;
	}
	@Override
	public String toString() {
		return "DropShip" ;
	}
}
