/*
 	Usage Pattern: 
	java Main 
 
 */

import UseExceptionsRatherThanReturnCode.*;

public class Main{
	public static void main(String args[]) {
		
		UseExceptionsRatherThanReturnCodes();
		
		
		
	}
	
	public static void UseExceptionsRatherThanReturnCodes() {
		
		DeviceHandle.addDefaultHandle("DEV1");
		
		DeviceHandle handle = DeviceHandle.getHandle("DEV1");
		DeviceRecord record = handle.retrieveDeviceRecord();
		
		System.out.printf("Record1: %s\nRecord2: %s", record.record1, record.record2);
	}
}