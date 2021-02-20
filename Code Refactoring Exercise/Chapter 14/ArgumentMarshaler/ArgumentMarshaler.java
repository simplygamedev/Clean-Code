package ArgumentMarshaler;

import java.util.*;
import ArgsException.*;

public interface ArgumentMarshaler {
	void set(Iterator<String> currentArgument) throws ArgsException;
}