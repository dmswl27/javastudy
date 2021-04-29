package prob3;

import java.sql.Struct;

public abstract class Bird {
	protected String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	protected abstract void fly();

	protected abstract void sing();
	
}