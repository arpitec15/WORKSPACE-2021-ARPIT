package com.generics;

public class Generic1<T> {

	T obj;

	public Generic1(T obj) {
		this.obj = obj;
	}

	public void show() {
		System.out.println("The type of show is " + obj.getClass().getName());
	}

	public T getObj() {
		return obj;
	}

}
