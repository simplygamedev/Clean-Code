package WriteYourTryCatchFinallyStatementFirst;

import java.io.FileInputStream;  
import java.util.ArrayList;

public class FileSectionRetriever {
	public static ArrayList<RecordedGrip> retrieveSection(String sectionName) throws StorageException {
		
		try {
			FileInputStream stream = new FileInputStream(sectionName);
			stream.close();
		}
		catch(Exception e) {
			//throw new StorageException("retrieval error", e);
		}
		return new ArrayList<RecordedGrip>();
	}
}