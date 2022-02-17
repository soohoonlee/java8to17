package me.ssoon.java8to17;

public interface Bar {

	void printName();

	/**
	 * @implSpec
	 * 이 구현체는 getName()으로 가져온 문자열을 대문자로 바꿔 출력한다.
	 */
	default void printNameUpperCase() {
		System.out.println(getName().toUpperCase());
	}

	// Object 의 메서드들은 재정의할 수 없다.

	String getName();
}
