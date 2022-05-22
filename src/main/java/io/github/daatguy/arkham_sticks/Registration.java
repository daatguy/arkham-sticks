package io.github.daatguy.arkham_sticks;

public class Registration<E> {

	private E entry;
	private String id;
	
	public Registration(E entryIn, String idIn) {
		this.entry = entryIn;
		this.id = idIn;
	}
	
	public String getID() {
		return this.id;
	}
	
	public E getEntry() {
		return this.entry;
	}
	
}
