package com;

public class Runner {
	public static void main(String[] args) {
		Map<Integer, Integer> map = new Map<Integer, Integer>();
		map.add(1, 11);
		map.add(2, 12);
		map.add(3, 13);
		map.add(4, 14);
		map.add(5, 15);
		map.add(6, 16);
		map.add(7, 17);
		map.add(8, 18);
		map.add(9, 19);
		map.size();
    	System.out.println("The size is: " +map.size());
		map.display();
	}
}
