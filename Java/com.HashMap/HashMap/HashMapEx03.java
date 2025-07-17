package com.list;
import java.util.*;
public class HashMapEx03 {

	public static void main(String[] args) {
		HashMap <String, Integer> map = new HashMap <> ();
		map.put("가길동", 100);
		map.put("나길동", 90);
		map.put("마길동", 80);
		map.put("라길동", 70);
		
		Set set = map.entrySet();
		Iterator it = set.iterator();
		while (it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();
			System.out.println("이름 : "+e.getKey()+", 점수 : "+e.getValue());
		}
		set = map.keySet();
		System.out.println("이름 : " + set);
		Collection values = map.values();
		
		it = values.iterator();
		int sum = 0;
		while (it.hasNext()) {
			Integer i = (Integer)it.next();
			sum += i;
			System.out.print(i+"\t");
		}
		System.out.println();
		System.out.println("총점 : "+ sum);
		System.out.println("평균 : "+sum/set.size());
		System.out.println("최고 점수 : "+Collections.max(values));
		System.out.println("최저 점수 : "+Collections.min(values));
	}
}
