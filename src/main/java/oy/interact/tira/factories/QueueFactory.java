package oy.interact.tira.factories;

import oy.interact.tira.model.Coder;
import oy.interact.tira.student.QueueImplementation;
import oy.interact.tira.util.QueueInterface;

public class QueueFactory {

	private QueueFactory() {
		// empty
	}

	public static QueueInterface<Integer> createIntegerQueue() {
		QueueImplementation<Integer> QueueImp = new QueueImplementation<>();
		return QueueImp;
	}

	public static QueueInterface<Integer> createIntegerQueue(int capacity) {
		QueueImplementation<Integer> QueueImp = new QueueImplementation<>(capacity);
		return QueueImp;
	}

	public static QueueInterface<String> createStringQueue() {
		QueueImplementation<String> QueueImp = new QueueImplementation<>();
		return QueueImp;
	}
	public static QueueInterface<String> createStringQueue(int capacity) {
		QueueImplementation<String> QueueImp = new QueueImplementation<>(capacity);
		return QueueImp;
	}

	public static QueueInterface<Coder> createCoderQueue() {
		QueueImplementation<Coder> QueueImp = new QueueImplementation<>();
		return QueueImp;
	}
}
