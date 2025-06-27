package InterEx;

public class Tank extends GroupUnit implements InterfaceRepair {

	public Tank () { //150
		super (150);
		hitPoint = MAX_HP;
	}
	
	@Override
	public String toString() {
		return "Tank" ; 
	}
}
