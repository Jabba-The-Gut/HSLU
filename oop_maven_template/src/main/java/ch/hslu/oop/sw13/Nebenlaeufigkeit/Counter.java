package ch.hslu.oop.sw13.Nebenlaeufigkeit;

public final class Counter {
	private long count;

	public synchronized void increment() {
		long temp = this.count;
		temp++;
		Thread.yield();
		this.count = temp;
	}

	public long getCount() {
		return this.count;
	}
}
