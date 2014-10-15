package command;

public class ValidationPair {
	
	public int status;
	public String message;
	public int[] args;

	public ValidationPair ( int status, String message) {
		
		this.status = status;
		this.message = message;
	}
}
