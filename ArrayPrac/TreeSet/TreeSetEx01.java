package com.list;
import java.util.*;
public class TreeSetEx01 {

	public static void main(String[] args) {
		TreeSet set = new TreeSet();
		String from = "b";
		String to = "d";
		set.add("abc");set.add("allen");set.add("bat");
		set.add("Cat");set.add("car"); set.add("disc");
		set.add("dance");set.add("dzzz"); set.add("DZZZ");
		set.add("elephant");set.add("elevator"); set.add("fan");
		set.add("flower");
		
		System.out.println(set);
		
		System.out.println(from + " to " + to);
		System.out.println(set.subSet(from, to));
		System.out.println(set.subSet(from, to+"zzzz"));
	}
}
