package WriteYourTryCatchFinallyStatementFirst;

public class WriteTryCatchFinallySectionUnitTests {
	public static void retrieveSectionShouldThrowOnInvalidFileName() {
		
		try {
			FileSectionRetriever.retrieveSection("invalidFileName");
			throw new Exception("\nIncorrect Behavior in Try When Invalid FileName was used.");
		}
		catch(Exception e) {
			
			System.out.print((e instanceof StorageException) ? 
					"\nCorrect Implementation of throwing behaviour when Invalid FileName was used." : 
					"\nIncorrect Behavior In Catch When Invalid FileName was used."
			);
		}
	}
}