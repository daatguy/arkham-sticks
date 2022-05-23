package io.github.daatguy.arkham_sticks.registry;

public abstract class Registration implements Registerer {

	private final String id;
	
	public Registration(String idIn) {
		this.id = idIn;
	}
	
	public String getID() {
		return this.id;
	}
	
}
