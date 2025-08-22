package poly;

public class AppleSpeaker implements Speaker {

	public AppleSpeaker() {
	System.out.println("===> AppleSpeaker 객체 생성...");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("AppleSpeaker -------- 소리 올라가요");

	}

	@Override
	public void volumeDown() {
		System.out.println("AppleSpeaker -------- 소리 내려가요");
		
	}

}
