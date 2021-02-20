package StringArgumentMarshaler;

import java.util.*;
import ArgsException.*;
import static ArgsException.ArgsException.ErrorCode.*;
import ArgumentMarshaler.*;

public class StringArgumentMarshaler implements ArgumentMarshaler {
	
	private String stringValue = "";
	
	public void set(Iterator<String> currentArgument) throws ArgsException {
		try {
			stringValue = currentArgument.next();
		} 
		catch (NoSuchElementException e) {
			throw new ArgsException(MISSING_STRING);
		}
	}
	
	public static String getValue(ArgumentMarshaler am) {	
		if (am != null && am instanceof StringArgumentMarshaler)
			return ((StringArgumentMarshaler) am).stringValue;
		else
			return "";
	}
}