package sample;

import java.util.Objects;

public class Workspace {
	private String name;

	public Workspace(String name) {
		Objects.requireNonNull(name, "name is required");
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
