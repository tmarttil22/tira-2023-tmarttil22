package oy.interact.tira.factories;

import java.util.Stack;

import oy.interact.tira.NotYetImplementedException;
import oy.interact.tira.student.StackImplementation;
import oy.interact.tira.util.StackInterface;

public class StackFactory {
	private StackFactory() {
		// Empty
	}

	public static StackInterface<Integer> createIntegerStack() {
		StackImplementation<Integer> stackImp = new StackImplementation<>();
		return stackImp;
	}

	public static StackInterface<Integer> createIntegerStack(int capacity) {
		StackImplementation<Integer> stackImp = new StackImplementation<>(capacity);
		return stackImp;
	}

	public static StackInterface<Character> createCharacterStack() {
		StackImplementation<Character> stackImp = new StackImplementation<>();
		return stackImp;
	}

	public static StackInterface<Character> createCharacterStack(int capacity) {
		StackImplementation<Character> stackImp = new StackImplementation<>(capacity);
		return stackImp;
	}
}
