/*
 	Usage Pattern: 
	java Main 
 
 */

import UseExceptionsRatherThanReturnCode.*;
import WriteYourTryCatchFinallyStatementFirst.*;

public class Main{
	public static void main(String args[]) {
		
		UseExceptionsRatherThanReturnCodes();
		WriteYourTryCatchFinallyStatementFirst();	
		
	}
	
	public static void UseExceptionsRatherThanReturnCodes() {
		
		DeviceController.addHandleWithRecord("DEV1", new DeviceRecord("Record1","Record2"));
		
		DeviceRecord record = DeviceController.getDeviceRecord("DEV1");
		
		System.out.printf("\nRecord1: %s, Record2: %s", record.record1, record.record2);
		
		DeviceController.sendShutDown("DEV1");
	}
	
	public static void WriteYourTryCatchFinallyStatementFirst() {
		WriteTryCatchFinallySectionUnitTests.retrieveSectionShouldThrowOnInvalidFileName();
	}
}