package me.ssoon.java8to17;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Foo {

	public static void main(String[] args) {
//		Function<Integer, Integer> plus10 = number -> number + 10;
		UnaryOperator<Integer> plus10 = number -> number + 10;
		System.out.println("plus10.apply(10) = " + plus10.apply(10));
//		Function<Integer, Integer> multiply2 = number -> number * 2;
		UnaryOperator<Integer> multiply2 = number -> number * 2;
		System.out.println("multiply2.apply(5) = " + multiply2.apply(5));

		Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2);
		System.out.println("multiply2AndPlus10.apply(5) = " + multiply2AndPlus10.apply(5));
		Function<Integer, Integer> plus10AndMultiply2 = plus10.andThen(multiply2);
		System.out.println("plus10AndMultiply2.apply(5) = " + plus10AndMultiply2.apply(5));


		Consumer<Integer> printT = System.out::println;
		printT.accept(10);

		Supplier<Integer> get10 = () -> 10;
		System.out.println("get10.get() = " + get10.get());

		Predicate<String> startWithK = s -> s.startsWith("K");
		System.out.println("startWithK.test(\"Korea\") = " + startWithK.test("Korea"));

		Predicate<Integer> isEven = integer -> integer % 2 == 0;
		System.out.println("isEven.test(10) = " + isEven.test(10));

//		BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;
		BinaryOperator<Integer> sum = (a, b) -> a + b;

		Foo foo = new Foo();
		foo.run();
	}

	private void run() {
		int baseNumber = 10;

		// 로컬 클래스
		class LocalClass {
			void printBaseNumber() {
				int baseNumber = 11;
				System.out.println("baseNumber = " + baseNumber); // 11
			}
		}

		// 익명 클래스
		Consumer<Integer> integerConsumer = new Consumer<Integer>() {
			@Override
			public void accept(Integer baseNumber) {
				System.out.println("baseNumber = " + baseNumber);
			}
		};

		// 람다
		IntConsumer printInt = x -> System.out.println(x + baseNumber);
		printInt.accept(10);

		// 로컬 클래스, 익명 클래스는 다른 scope
		// 람다는 같은 scope
	}
}
