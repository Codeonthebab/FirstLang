package poly;

public class SonySpeaker implements Speaker{
	
	public SonySpeaker() {
       System.out.println("===> SonySpeak");		
	}
	
	@Override
	public void volumeUp () {
		System.out.println("===> SonySpeak Volume up");			
	}
	@Override
     public void volumeDown () {
	System.out.println("===> SonySpeak Volume Down");
	}

}
