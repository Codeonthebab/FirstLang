package com.excp;

class InstallException extends Exception {
	public InstallException(String msg) {
		super (msg);
	}
}

class SpaceException extends Exception {
	public SpaceException(String msg) {
		super (msg);
	}
}
class memoryException extends Exception {
	public memoryException(String msg) {
		super (msg);
	}
}
public class ExceptionEx09 {
	
	public static void main (String [] args) throws Exception {
	try {
		startInstall ();
		copyfiles();	
	} catch (SpaceException se) {
		System.out.println("에러메시지 : "+se.getMessage());
		se.printStackTrace();
		System.out.println("공간을 확보한 후 다시 설치하시길 바랍니다.");
	} catch (memoryException me) {
		System.out.println("에러메시지 : "+me.getMessage());
		me.printStackTrace();
		System.gc(); // 가비지 컬렉션. 
		System.out.println("다시 설치하시길 바랍니다.");
		//deleteTempFile ();
	} finally {
		deleteTempFiles();
	}
	} // end main
	
	static void Install() throws InstallException {
		try {
			startInstall();
			copyfiles();
		} catch (SpaceException se) {
			InstallException ie =new InstallException("설치 중 예외 발생 !!");
			ie.initCause(se); // 에러의 원인을 SpaceException으로 등록해야겠다하는 코드
			throw ie;
		} catch (memoryException me) {
			InstallException ie =new InstallException("설치 중 예외 발생 !!");
			ie.initCause(me); // 에러의 원인을 SpaceException으로 등록해야겠다하는 코드
			throw ie;
		} finally {
			deleteTempFiles ();
		}
	}
	
	static void startInstall() throws SpaceException, memoryException {
		if (!enoughSpace ()) { // 설치할 공간이 부족하멵
			throw new SpaceException ("설치할 공간이 부족합니다");
		}
		if (!enoughMemory()) { // 메모리 공간이 없으면
			throw new SpaceException ("메모리가 부족합니다");
		}
	}
	static void copyfiles() {
		
	}
	static void deleteTempFiles ( ) {
		
	}
	static boolean enoughSpace() {
		//설치하는 필요한 공간이 있는지를 확인할 것
		return false;
	}
	static boolean enoughMemory() {
		//설치하는 필요한 공간이 있는지를 확인할 것
		return false;
	}
}
 