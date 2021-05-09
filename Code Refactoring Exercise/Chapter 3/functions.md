# Functions
* Should be no longer than 3-4 lines.

__[Blocks and Indenting]__
* E.g. If, Else, While Statements
* Should only be one-two lines long (Abstracted by a function call)
* Implies functions should not be large enough to hold nested structures
* Indent level of a function should not be greater than one or two.
 
__[FUNCTIONS SHOULD DO ONE THING, THEY SHOULD DO IT WELL, THEY SHOULD DO IT ONLY]__
* If a function does only stepes that are one level below the stated name of the function, then the function is doing one thing.
* E.g. RenderPageWithSetupsAndTeardowns() // Check to see if page is a test page, include the setups & teardowns. In either case, we render the page in HTML

__[Sections withing Functions]__
* E.g. Declarations, Initialiations, Sieve
* Functions that do one thing only cannot be reasonably divided into sections.

__[Statements]__
* Statements within our functions should have thew same level of abstraction

|Example|
---|
&nbsp; .\.\. renderPageWithSetupsAndTeardowns {|
&nbsp; &nbsp; .\.\. includeSetupPages(...);|
&nbsp; &nbsp; &nbsp; .\.\. includeTeardownPages(...);|
}|

__[Reading Code from Top to Bottom]__
* We want code to read like a top down narrative
* E.g. Every function to be followed by those at the next level of abstraction

__[Switch/If Statements]__
* It is hard for them to do only one thing because by their nature, they do N-things
* We can't always avoid them
* However, we can use polymorphism to ensure it is buried in a low-level class & it is never repeated (Example 1)
* You can also use the Abstract Factory Pattern (GOF)
* Switch/If statements are tolerated if tget appear only once, are used to create polymorphic objects, and are hidden behind an inheritance relationship, so that the rest of the system can't see them (Example 2)

|Example 1|
---|
calculatePay(Employee e) {|
switch(e.type) {|
case COMMISSIONED:|
&nbsp;&nbsp; calculateCommisionedPay(e);|
case HOURLY:|
&nbsp;&nbsp; calculateHourlyPay(e);|
...|
}|

|Example 2|
---|
public class EmployeeFactoryImpl implements EmployeeFactory {|
&nbsp; &nbsp; public Employee makeEmployee(EmployeeRecord r) throws InvalidEmployeeType {|
&nbsp; &nbsp; &nbsp; &nbsp;switch(e.type) {|
&nbsp; &nbsp; &nbsp; &nbsp; case COMMISSIONED:|
&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; return new CommissionedEmployee\(r\);|
&nbsp; &nbsp; &nbsp; &nbsp; case HOURLY:|
&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; return new HourlyEmployee(e);|
...|
}|

__[Use Descriptive Names]__
* Don't be afraid to make a name long
* A long descriptive name is better than a short enigmatic name

__[FUNCTION ARGUMENTS]__
* (Ideal) Niladic, Monadic, Dyadic, Triadic, ... (Not so Good)
* Niladic means no arguments, Monadic 1 argument, and so on.
 
__[FLAG ARGUMENTS]__
* E.g. Passing a boolean into a function
* It indicates that the function does more than one thing.

__[ARGUMENT OBJECTS]__
* If a function seems to need two or more arguments, it is likely that some of those arguments ought to be wrapped into a class of their own.
* When groups of variables are passed together, they likely part of a concept that deservs a name of its own, in the form of a class/structure.

__[VERBS & KEYWORDS]__
* Choosing a good name for a function helps in explaining its intent as well as the order and intent of its arguments.
* In the case of a monad, the function and argument should form a nice verb/noun pair, E.g. writeField(name)

__[HAVE NO SIDE EFFECTS]__
* Your function promises to do one thing, so it should not be doing other hidden things.

|Example|
---|
checkPassword(String userName, String password) {|
&nbsp; &nbsp; ...|
&nbsp; &nbsp; if("Valid Password".equals(phrase)) {|
&nbsp; &nbsp; &nbsp; &nbsp; Session.initialize(); //This is the side effect|
&nbsp; &nbsp; &nbsp; &nbsp; return true;|
&nbsp; &nbsp;}//Because your function promises to check password|
}//But it is also initializing a Session|

__[Output Arguments]__
* In general, avoid output arguments
* E.g. An argument that was actually an ouput rather than an input, such as refs or out in C#
* If your function must change the state of something, have it change the state of its owning object, E.g. one of its properties

__[COMMAND QUERY SEPARATION]__
* Functions should either do something or answer something, but not both.

__[PREFER USING TRY-CATCH TO GET EXCEPTIONS RATHER THAN RETURN ERROR CODES]__

__[EXTRACT TRY-CATCH BLOCKS INTO THEIR OWN FUNCTIONS]__ 
* A Function should only do one thing, Error handling is one thing

__[DON'T REPEAT YOURSELF]__

__[STRUCTURED PROGRAMMING]__
* Edgar Djikstra (Every function & Every Block within a function should only have one entry & one exit, E.g. Only one return statement, no break/continue/goto)
* If functions are small though, occasional multiple return/break/continue ought to be fine & may even allow more expressiveness.
* However, goto only makes sense in large functions, so it should be avoided.

__[HOW DO YOU WRITE YOUR FUNCTIONS LIKE THIS?]__
* You start out long and complicated
* Refine and massage the code (Split Functions, Change Names, Eliminate Duplication, etc)
* Do so while keeping tests passing
* Eventually, you'll wind up with functions that abides by the rules.