package com.learning.lambdas;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Collections {

	public static void main(String[] args) {
		List<Integer> l = Arrays.asList(1,2,3,4,5,6,7,7,8);
		Collection<Integer>  c = new HashSet<Integer>(l);
		System.out.println(c);
		
		Arrays.asList(6,2,1,8,4,0).stream().sorted().findFirst().ifPresent(System.out::println);
		Stream.of("apple","bnanana","organge").filter(fruit -> fruit.startsWith("a")).forEach(fruit -> System.out.println(fruit));
		
		List<String> s = Stream.of("apple","orange").map(fruits -> fruits.toUpperCase()).collect(Collectors.toList());
		System.out.println(s);
		
		List<String> ll = Arrays.asList("test","kunal");
		Iterator<String> it = ll.iterator();
		
		while( it.hasNext()) {
			
			System.out.println(it.next());
			
		}
				
	}

	

}
