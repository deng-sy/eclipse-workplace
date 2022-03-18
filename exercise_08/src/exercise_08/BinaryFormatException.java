package exercise_08;

public class BinaryFormatException extends Exception{
	private String binString;

	public BinaryFormatException(String binString) {
		super(binString+" is not a binary string.");
		this.binString = binString;
	}
	
}
