package com.venkat.test;

import java.util.function.Function;
import java.util.stream.Stream;

public class TestClass implements TwoArgIntOperator {

	public void testMethod() {
		System.out.println("Super Class");
	}

	@Override
	public int op(int a, int b) {
		return a + b;
	}

	public static void main(String[] args) {
		TwoArgIntOperator addTwoInts = (a, b) -> a + b;
		int result = method(addTwoInts);
		System.out.println("Result: " + result);

		Function<String, String> fn = parameter -> parameter + " from lambda";
		System.out.println(add("Message ", fn));

		Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2);
	}

	public static int method(TwoArgIntOperator operator) {
		return operator.op(5, 10);
	}

	public static String add(String string, Function<String, String> fn) {
		return fn.apply(string);
	}

}
