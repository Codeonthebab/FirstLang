package InterEx;

public class SCV extends GroupUnit implements InterfaceRepair {
	public SCV() {
	super (60);
	hitPoint = MAX_HP;
	}
	
	void repair (InterfaceRepair r) {
		if (r instanceof Unit ) { 
			Unit u = (Unit)r;
			
			while (u.hitPoint != u.MAX_HP) {
				u.hitPoint++;
			}
			System.out.println(u.toString()+"의 수리가 완료되었습니다.");
		}
	}
}
