package me.ssoon.java8to17;

@FunctionalInterface
public interface RunSomething {

	int doIt(int number);

	static void printName() {
		System.out.println("Ssoon");
	}

	default void printAge() {
		System.out.println("40");
	}
}
