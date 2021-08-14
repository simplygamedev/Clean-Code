package UseExceptionsRatherThanReturnCode;

public class DeviceHandle {
	
	private String handleName;
	private DeviceRecord record;
	
	public DeviceHandle(String handleName, DeviceRecord record) {
		this.handleName = handleName;		
		this.record = record;
	}
	
	public DeviceRecord retrieveDeviceRecord() {
		return record;
	}
	
	public String getName() {
		return handleName;
	}
}