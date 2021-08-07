package UseExceptionsRatherThanReturnCode;

public class DeviceShutDownError extends Exception {
	public DeviceShutDownError(String exception) {
		super(exception);
	}
}