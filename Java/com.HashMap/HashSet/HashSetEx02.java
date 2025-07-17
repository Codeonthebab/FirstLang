package com.list;
import java.util.*;
public class HashSetEx02 {
	
	public static void main(String[] args) {
		HashSet setA = new HashSet ();
		HashSet setB = new HashSet ();
		HashSet setHab = new HashSet ();
		HashSet setkyo = new HashSet ();
		HashSet setCha = new HashSet ();
		
		setA.add("1");setA.add("2");setA.add("3");setA.add("4");setA.add("5");
		System.out.println("A : "+setA);
		
		setB.add("4");setB.add("5");setB.add("6");setB.add("7");setB.add("8");
		System.out.println("B : "+setB);
		
		Iterator <String> it = setA.iterator();
		
		while (it.hasNext()) {
			Object tmp = it.next();
			if (setB.contains(tmp)) 
				setkyo.add(tmp);
		}
		System.out.println("A와 B의 교집합 => " + setkyo);
		System.out.println();
		
		it = setA.iterator();
		while (it.hasNext()) {
			setHab.add(it.next());
		}
		it = setB.iterator();
		while (it.hasNext()) {
			setHab.add(it.next());
		}
		System.out.println("A와 B의 합집합 => " +setHab);
	}
}
