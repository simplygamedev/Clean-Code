package UseExceptionsRatherThanReturnCode;

import java.util.HashMap;

public class DeviceHandle {
	
	private static HashMap<String, DeviceHandle> map = new HashMap<>();
	private String handleName;
	private DeviceRecord record;
	
	public DeviceHandle(String handleName, DeviceRecord record) {
		this.handleName = handleName;		
		this.record = record;
	}
	
	public static DeviceHandle getHandle(String handle) {
		return map.get(handle);
	}
	
	public DeviceRecord retrieveDeviceRecord() {
		return record;
	}
	
	public static void addDefaultHandle(String handleName) {
		map.put(handleName, new DeviceHandle(handleName, new DeviceRecord("Hello", "World")));
	}
}