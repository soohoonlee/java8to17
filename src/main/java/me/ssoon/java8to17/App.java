package me.ssoon.java8to17;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import me.ssoon.Bar;
import me.ssoon.DefaultBar;

public class App {

	public static void main(String[] args) {
		UnaryOperator<String> hi = Greeting::hi;
		System.out.println("hi.apply(\"Soohoon\") = " + hi.apply("Soohoon"));

		Greeting greeting = new Greeting();
		UnaryOperator<String> hello = greeting::hello;
		System.out.println("hello.apply(\"soohoon\") = " + hello.apply("soohoon"));

		Supplier<Greeting> newGreeting = Greeting::new;
		System.out.println("newGreeting.get().hello(\"soohoon\") = " + newGreeting.get().hello("soohoon"));

		Function<String, Greeting> newGreeting2 = Greeting::new;
		System.out.println("newGreeting2.apply(\"soohoon\").getName() = " + newGreeting2.apply("soohoon").getName());

		String[] names = {"dduddu", "nana", "kkukku", "yooddu"};
		Arrays.sort(names, String::compareToIgnoreCase);
		System.out.println("Arrays.toString(names) = " + Arrays.toString(names));

		Bar bar = new DefaultBar("soohoon");
		bar.printName();
		bar.printNameUpperCase();
	}
}
