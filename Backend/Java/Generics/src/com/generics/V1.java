package com.generics;

import java.util.ArrayList;

public class V1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		ArrayList<Object> l = new ArrayList<String>();

//		collection can hold only objects not primitives
//		ArrayList<int>	x = new ArrayList<int>();

//		array list manipulations

//		ArrayList<String> x = new ArrayList<String>();
//		x.add("1");
//		x.add("2");
//		x.add("3");
//		x.add("4");
//		x.add("5");
//		x.add("6");
//		x.add("7");
//
//		for (int i = 0; i < x.size(); i++) {
//			System.out.println("Removing " + x.get(i));
//			x.remove(i);
//
//		}
//		System.out.println("-----------------");
//		System.out.println(x);
//		System.out.println("-----------------");

		Generic1<String> g1 = new Generic1<String>("Arpit");
		g1.show();
		System.out.println(g1.getObj());
		System.out.println("**********************");
		Generic1<Integer> g2 = new Generic1<Integer>(1);
		g2.show();
		System.out.println(g2.getObj());
		System.out.println("**********************");
		System.out.println("Bounded Types ");

//		We can define bounded types only by using extends keyword.
//		We can't use implements and super keyword
//		We can only use ? at left hand side not right side
		GenericBoundedToNumbers<Integer, Integer> t1 = new GenericBoundedToNumbers<Integer, Integer>(2, 3);
		t1.add();

	}

}
