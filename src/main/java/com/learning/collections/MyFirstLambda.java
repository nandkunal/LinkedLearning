package com.learning.collections;

import java.util.function.*;

public class MyFirstLambda {

	public static void main(String[] args) {
		// Predicate - Represents a predicate (boolean-valued function) of one argument.
		Predicate<String> p = (s) -> s.length() > 10;
		System.out.println(p.test("Kunal"));
		//Consumer<T> - Represents an operation that accepts a single input argument and returns no result.
		Consumer<String> c = (s)->System.out.println(s);
		c.accept("Khaware");
		
		//Function<T,R> - Represents a function that accepts one argument and produces a result.
		Function<Integer,String> f = (s)-> Integer.toString(s);
		System.out.println(f.apply(20));
		
		//Supplier<T> - Represents a supplier of results.
		Supplier <String> supplier = ()->"This is functional interface";
		System.out.println(supplier.get());
		
		Calculate cal = (a, b)-> a+b;
		System.out.println(cal.cal(2, 3));
		
		Runnable r = () -> System.out.println("hello runnable from lambda");
		r.run();
		
		IntFunction<String> in = Integer::toString;
		System.out.println(in.apply(23).length());
		
		
	}

}
