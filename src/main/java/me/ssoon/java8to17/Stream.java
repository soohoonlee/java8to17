package me.ssoon.java8to17;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("dduddu");
		names.add("nana");
		names.add("kkukku");
		names.add("yooddu");

		final List<String> collect = names.stream()
				.map(s -> {
					System.out.println("s = " + s);
					return s.toUpperCase();
				}).collect(Collectors.toList());
		collect.forEach(System.out::println);

		System.out.println("=================");

		names.forEach(System.out::println);

		for (String name : names) {
			if (name.startsWith("d")) {
				System.out.println("name.toUpperCase() = " + name.toUpperCase());
			}
		}

		final List<String> collect1 = names.parallelStream().map(s -> {
			System.out.println(s + " " + Thread.currentThread().getName());
			return s.toUpperCase();
		}).toList();
		collect1.forEach(System.out::println);
	}
}
