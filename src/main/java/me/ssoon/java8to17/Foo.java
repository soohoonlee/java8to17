package me.ssoon.java8to17;

public class Foo {

	public static void main(String[] args) {
		final int baseNumber = 10;
		RunSomething runSomething = number -> number + baseNumber;
		System.out.println(runSomething.doIt(1));
	}
}
