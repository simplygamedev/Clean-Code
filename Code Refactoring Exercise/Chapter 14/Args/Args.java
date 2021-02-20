package Args;

import static ArgsException.ArgsException.ErrorCode.*;
import java.util.*;
import ArgsException.*;

import StringArgumentMarshaler.*;
import BooleanArgumentMarshaler.*;
import IntegerArgumentMarshaler.*;
import ArgumentMarshaler.*;

public class Args {
	
	private Map<Character, ArgumentMarshaler> marshalers;
	private Set<Character> argsFound;
	private ListIterator<String> currentArgument;

	private String[] args;
	
	public Args(String schema, String[] args) throws ArgsException {
		marshalers = new HashMap<Character, ArgumentMarshaler>();
		argsFound = new HashSet<Character>();

		this.args = args;

		parseSchema(schema);
		parseArgumentStrings(Arrays.asList(args));
	}
	
	private void parseSchema(String schema) throws ArgsException {

		String[] _schema = schema.split(",");

		for (String element : _schema)
			if (element.length() > 0)
				parseSchemaElement(element.trim());
	}
	
	private void parseSchemaElement(String element) throws ArgsException {
		
		char elementId = element.charAt(0);
		String elementTail = element.substring(1);
		validateSchemaElementId(elementId);
		
		if (elementTail.length() == 0){
			marshalers.put(elementId, new BooleanArgumentMarshaler());
		}
		else if (elementTail.equals("*")){
			marshalers.put(elementId, new StringArgumentMarshaler());
		}
		else if (elementTail.equals("#")){
			marshalers.put(elementId, new IntegerArgumentMarshaler());
		}
		//else if (elementTail.equals("##"))
			//marshalers.put(elementId, new DoubleArgumentMarshaler());
		//else if (elementTail.equals("[*]"))
			//marshalers.put(elementId, new StringArrayArgumentMarshaler());
		else
			throw new ArgsException(INVALID_ARGUMENT_FORMAT, elementId, elementTail);
	}

	private void validateSchemaElementId(char elementId) throws ArgsException {
		
		if (!Character.isLetter(elementId))
			throw new ArgsException(INVALID_ARGUMENT_NAME, elementId, null);
	
	}
	
	private void parseArgumentStrings(List<String> argsList) throws ArgsException
	{
		for (currentArgument = argsList.listIterator(); currentArgument.hasNext();) {		
			String argString = currentArgument.next();
			
			if (argString.startsWith("-")) {
				parseArgumentCharacters(argString.substring(1));
			} 
			else if(argString.length() <= 1){
				parseArgumentCharacters(argString);
			}
			else {
				throw new ArgsException(UNEXPECTED_ARGUMENT, argString);
			}
		}
	}

	private void parseArgumentCharacters(String argChars) throws ArgsException {
		for (int i = 0; i < argChars.length(); i++)
			parseArgumentCharacter(argChars.charAt(i));
	}
	
	private void parseArgumentCharacter(char argChar) throws ArgsException {
		ArgumentMarshaler m = marshalers.get(argChar);
		
		if (m == null) {
			throw new ArgsException(UNEXPECTED_ARGUMENT, argChar, null);
		} 
		else {
			argsFound.add(argChar);
			
			try 
			{
				m.set(currentArgument);
			} 
			catch (ArgsException e) 
			{
				e.setErrorArgumentId(argChar);
				throw e;
			}
		}
	}
	
	public boolean has(char arg) {
		return argsFound.contains(arg);
	}
	
	public int nextArgument() {
		return currentArgument.nextIndex();
	}
	
	public boolean getBoolean(char arg) {
		return BooleanArgumentMarshaler.getValue(marshalers.get(arg));
	}
	
	public String getString(char arg) {
		return StringArgumentMarshaler.getValue(marshalers.get(arg));
	}
	
	public int getInt(char arg) {
		return IntegerArgumentMarshaler.getValue(marshalers.get(arg));
	}
	
	//public double getDouble(char arg) {
		//return DoubleArgumentMarshaler.getValue(marshalers.get(arg));
	//}
	
	//public String[] getStringArray(char arg) {
		//return StringArrayArgumentMarshaler.getValue(marshalers.get(arg));
	//}
}