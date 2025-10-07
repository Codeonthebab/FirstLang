package polymorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV  implements TV {
    // @Resource --> 객체의 이름으로 의존성을 처리함
	@Autowired // -> 변수의 타입을 기준으로 객체를 검색하여 의존성 주입을 처리함
	//@Qualifier("apple")// 의존성 주입될 객체의 아이디나 이름을 지정함
	//@Resource(name = "apple")	
	private Speaker speaker;
	
	public LgTV() {
	   System.out.println("====> LgTV 객체 생성 ....");
	}
	
	
	@Override
	public void powerOn() {
		System.out.println("LgTV --- 전원 켠다.");
	}
	

	@Override
	public void powerOff() {
		System.out.println("LgTV --- 전원 끈다.");
	}

	@Override
	public void volumeUp() {
		System.out.println("LgTV --- 소리 올린다.");
	}

	@Override
	public void volumeDown() {
		System.out.println("LgTV --- 소리 내린다.");
	}
}
