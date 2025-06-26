package com.excp;
import java.io.*;
public class ExceptionEx08 {
	
	public static void main (String [] args) throws Exception {
	try {
		startInstall ();
		copyfiles();
		deleteTempFiles();
		
	} catch (Exception e) {
		e.printStackTrace();
		//deleteTempFile ();
	} finally {
		deleteTempFiles();
	}
	}
	static void startInstall() {
		
	}
	static void copyfiles() {
		
	}
	static void deleteTempFiles ( ) {
		
	}
}
 