package com.list;
import java.util.*;
public class HashMapEx01 {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap <> ();
		
		map.put("만화", "블리치");
		map.put("호러", "스크림");
		map.put("영화", "글레이에이터");
		
		System.out.println(map);
		String key;
		Set set = map.keySet();
		Iterator <String> it = set.iterator();
		while (it.hasNext()) {
			key = it.next();
			System.out.println(map.get(key));
		}
		System.out.println();
		
		map.put("영화", "야당");
		System.out.println(map);

	}
}
