package Trabalho.model;

public enum Status {
	
	Feito(true), NaoFeito(false); 
	
	
	private boolean status;

	private Status(Boolean status) {
		this.status = status;
	}
	

}
