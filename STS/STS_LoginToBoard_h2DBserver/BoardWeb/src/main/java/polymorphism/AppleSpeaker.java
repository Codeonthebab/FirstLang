package polymorphism;

import org.springframework.stereotype.Component;

//@Component("apple")
public class AppleSpeaker implements Speaker {

	public AppleSpeaker() {
	   System.out.println("===> AppleSpeaker 객체 생성...");
	}
	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		System.out.println("AppleSpeaker ----- 소리 올린다.");
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("AppleSpeaker ----- 소리 내린다.");
	}

}
