package UseExceptionsRatherThanReturnCode;

import java.util.HashMap;

public class DeviceController {
	
	private static HashMap<String, DeviceHandle> map = new HashMap<>();
	
	public void addHandle(String handleName, DeviceRecord record){	
		addHandleWithRecord(handleName, record);
	}
	
	public static void sendShutDown(String deviceHandle) {
		try {
			tryToShutDown(deviceHandle);
		}
		catch (DeviceShutDownError e){
			System.out.print(e.toString());
		}
	}
	
	private static void tryToShutDown(String deviceHandle) throws DeviceShutDownError {
			
		DeviceHandle handle = getHandle(deviceHandle);
		DeviceRecord record = handle.retrieveDeviceRecord();
		
		System.out.printf("\nShutting down device %s", handle.getName());
	}
	
	public static DeviceHandle getHandle(String handle) {
		return map.get(handle);
	}
	
	public static DeviceRecord getDeviceRecord(String handle) {
		return getHandle(handle).retrieveDeviceRecord();
	}
	
	public static void addHandleWithRecord(String handleName, DeviceRecord record) {
		map.put(handleName, new DeviceHandle(handleName, record));
	}
}