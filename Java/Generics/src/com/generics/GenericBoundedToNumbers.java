package com.generics;

public class GenericBoundedToNumbers<T extends Number,P extends Number> {

	T a;
	P b;

	public GenericBoundedToNumbers(T a, P b) {
		this.a = a;
		this.b = b;
	}

	@SuppressWarnings("unchecked")
	public void add() {
		
		if(a.getClass()== Integer.class) {
			System.out.println("Sum is " + (a.intValue() + b.intValue()));
		}
		else
			System.out.println("Error 	" );
	}
}
