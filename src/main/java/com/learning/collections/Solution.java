package com.learning.collections;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Solution {
	 private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
	
			//System.out.println("Enter size of list");
			int sizeOfList  =  scanner.nextInt();
			//System.out.println(sizeOfList);
			//System.out.println("Enter elements");
			int i = 0;
			List<Integer> l = new ArrayList<Integer>();
			while( i< sizeOfList) {
				l.add(scanner.nextInt());
				i++;
			}
			//System.out.println("Enter command call separated by comma");
			String[]  commands = scanner.next().split(",");
			Iterator it = l.iterator();
			Peeker p = new Peeker(it);
			printToConsoleWithCommands(p,commands);
			
			
			

	}

	private static void printToConsoleWithCommands(Peeker p, String[] commands) {
		try {
			for (String c: commands) {
				switch(c) 
				{ 
				case "next": 
					System.out.println(p.next()); 
					break; 
				case "hasNext": 
					System.out.println(p.hasNext()); 
					break; 
				case "peek": 
					System.out.println(p.peek()); 
					break; 
				default: 
					System.out.println("no matching command defined"); 
				} 

			}
		}catch(NoSuchElementException e) {
			System.out.println("ne");
		}
	}

}
class Peeker  {

    private Iterator<Integer> it;
    private Integer temp;
    public Peeker(Iterator<Integer> it) {
        this.it = it;
        };
        
        public Integer peek() {
            if(temp !=null) {
                return temp;
            } else {
                if(it.hasNext()) {
                    temp = ((Integer)it.next());
                    return temp;//5
                } else {
                    return null;
                }
            }
        }
        
        public boolean hasNext(){
            return (temp !=null || it.hasNext());//true
        }
        
        public Integer next() {
            if(temp !=null) {
                Integer result = temp;
                temp = null;
                return result; //5
            } else {
                return it.next();
            }
        }
        
    
	
}
