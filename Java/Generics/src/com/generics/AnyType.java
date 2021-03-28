package com.generics;

import java.util.ArrayList;

public class AnyType {

	
	public void anyTypes(ArrayList<String> list) {

	}

	public void anyTypes1(ArrayList<?> list) {

	}

	public void anyTypes3(ArrayList<? extends Generic1> list) {

	}

//	in this	we can pass Array List of X type or its super classes
//	if  X is an interface then we can call this method by  passing 
//	ArrayList of either X type or its super class of implementation class (of X)
	public void anyTypes2(ArrayList<? super X> list) {

		list.add(null);
	}
	
}
