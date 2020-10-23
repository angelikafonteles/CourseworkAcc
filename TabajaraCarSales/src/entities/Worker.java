package entities;

import entities.enums.WorkerLevel;

public class Worker {
	
	private String name;
	private WorkerLevel level;
	
	public Worker() {
		super();
	}
	
	public Worker(String name, WorkerLevel level) {
		super();
		this.name = name;
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Nome: "
				+ name
				+ "\nNivel: "
				+ level;
	}
	
}
