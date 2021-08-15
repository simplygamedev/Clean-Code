package WriteYourTryCatchFinallyStatementFirst;

public class StorageException extends Exception {
	public StorageException(String exception) {
		super(exception);
	}
	
	public StorageException(String exception, Throwable cause) {
		super(exception, cause);
	}
}