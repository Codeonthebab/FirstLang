package poly;



public class SamsungTV implements TV {

	private Speaker speaker;
	private int price;
	
	public SamsungTV () {
		System.out.println("===> SamsungTV(1) 객체 생성...");
	}
	
	public SamsungTV(Speaker speaker) {
		System.out.println("===> SamsungTV(2) 객체 생성...");
		this.speaker = speaker;
	}

	public SamsungTV(Speaker speaker, int price) {
		System.out.println("===> SamsungTV(3) 객체 생성...");
		this.speaker = speaker;
		this.price = price;
	}

	/*
	public SamsungTV (SonySpeaker speaker) {
		System.out.println("===> SamsungTV 객체 생성...");
		this.speaker = speaker;
	}
	*/
	@Override
	public void powerOn() {
		speaker = new AppleSpeaker();
		System.out.println("SamsungTV --- 전원 켬");
		System.out.printf("가격 =========> "+price+"원\n");
	}
	
	@Override
	public void powerOff() {
		speaker = new AppleSpeaker();
		System.out.println("SamsungTV --- 전원 끔");
	}
	
	@Override
	public void volumeUp() {
		speaker = new AppleSpeaker();
		System.out.println("SamsungTV --- 볼륨 업");
	}
	@Override
	public void volumeDown() {
		speaker = new AppleSpeaker();
		System.out.println("SamsungTV --- 볼륨 다운");
	}
	
	public void initMethod() {
		System.out.println("객체 초기화 작업처리...");
	}
	
	public void DestroyMethod() {
		System.out.println("객체 delete 작업처리...");
	}
}
