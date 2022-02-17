package me.ssoon.java8to17;

public class DefaultBar implements Bar {

	String name;

	public DefaultBar(String name) {
		this.name = name;
	}

	@Override
	public void printName() {
		System.out.println(this.name);
	}

	@Override
	public void printNameUpperCase() {
		System.out.println("name = " + name.toUpperCase());
	}

	@Override
	public String getName() {
		return this.name;
	}
}
