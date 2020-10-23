package entities;

import entities.enums.WorkerLevel;

public class Manager extends Worker{
	
	private String passcode;

	public Manager() {
		super();
	}

	public Manager(String name, WorkerLevel level, String passcode) {
		super(name, level);
		this.passcode = passcode;
	}

	public String getPasscode() {
		return passcode;
	}

	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}
	
}
