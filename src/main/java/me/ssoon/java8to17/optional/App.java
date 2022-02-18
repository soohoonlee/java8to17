package me.ssoon.java8to17.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {

	public static void main(String[] args) {
		List<OnlineClass> springClasses = new ArrayList<>();
		springClasses.add(new OnlineClass(1, "spring boot", true));
		springClasses.add(new OnlineClass(2, "spring data jpa", true));
		springClasses.add(new OnlineClass(3, "spring mvc", false));
		springClasses.add(new OnlineClass(4, "spring core", false));
		springClasses.add(new OnlineClass(5, "rest api development", false));

		Optional<OnlineClass> optional = springClasses.stream()
				.filter(onlineClass -> onlineClass.getTitle().startsWith("spring"))
				.findFirst();
//		optional.ifPresent(onlineClass -> System.out.println(onlineClass.getTitle()));

		OnlineClass onlineClass = optional.orElse(createNewClass());
	}

	private static OnlineClass createNewClass() {
		return new OnlineClass(6, "new class", true);
	}
}
