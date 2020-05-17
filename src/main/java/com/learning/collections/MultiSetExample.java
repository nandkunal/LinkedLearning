package com.learning.collections;

import java.util.Arrays;
import java.util.List;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public class MultiSetExample {

	public static void main(String[] args) {
		  
		Multiset<String> multiset = HashMultiset.create(); 
		  
		multiset.add("Kunal,Nand,Khaware");
		multiset.add("Kunal,Nand,Khaware"); 
		multiset.add("Khaware,Nand,Kunal"); 
		multiset.entrySet().forEach(s -> System.out.println(s.getElement() + " - " + s.getCount()));
		List<String> s = Arrays.asList("test","kunal","khaware");
		System.out.println(s);
	}

}
