import Args.Args;
import ArgsException.*;
import static ArgsException.ArgsException.ErrorCode.*;

import java.util.Arrays;

/*
	Usage Pattern: 
	java Main l -d "Hello World" -p 10000 

	Order of the Command Line Inputs Don't Matter
*/
public class Main {
	public static void main(String args[]) {
		try {
			Args arg = new Args("l,p#,d*", args);

			boolean logging = arg.getBoolean('l');
			int port = arg.getInt('p');
			
			String directory = arg.getString('d');

			if(directory==null || port == 0) //To Ensure the program only works if you provide both port and directory information
				throw new ArgsException(INVALID_ARGUMENT_FORMAT, String.join(", ", Arrays.asList(args)));

			executeApplication(logging, port, directory);
		} 
		catch (ArgsException e) {
			System.out.printf("Argument error: %s\n", e.errorMessage());
		}
	}

	public static void executeApplication(boolean bool, int integer, String dir){

		if(bool)
			System.out.printf("%s\n" +
					"%b\n" +
					"%d\n" + 
					"%s\n", "Result:", bool, integer, dir);
	}
}