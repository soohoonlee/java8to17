package me.ssoon.java8to17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

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

		List<String> name = new ArrayList<>();
		name.add("dduddu");
		name.add("nana");
		name.add("kkukku");
		name.add("yooddu");
		name.forEach(System.out::println);

		for (String s : name) {
			System.out.println(s);
		}

		Spliterator<String> spliterator = name.spliterator();
		Spliterator<String> stringSpliterator = spliterator.trySplit();
		while (spliterator.tryAdvance(System.out::println));
		System.out.println("===========================");
		while (stringSpliterator.tryAdvance(System.out::println));

		name.removeIf(s -> s.startsWith("d"));
		name.forEach(System.out::println);

		name.add("dduddu");
		name.sort(String::compareToIgnoreCase);
		name.forEach(System.out::println);

		Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
		name.sort(compareToIgnoreCase.reversed());
		name.forEach(System.out::println);
	}
}
