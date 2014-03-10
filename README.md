## Property Asserter
This is a Java JUnit testing utility to allow easy testing of *getter/setter* methods for properties.

The implementation was originally written by Scott Leberknight and discussed in [Do You Unit Test Getters and Setters?][]
 It was again discussed by myself, Josef Betancourt, at [Testing getter/setter using JUnit][]

Lately the original source code archive is not available so I decided to create this project.

## Background
There are many discussions regarding the usefulness or return on investment of unit testing property access in Java.

One of the issues is that Java could be criticized that unlike other languages, it does not have real Object properties, just programming
idioms such as method names.  So, a method named getValue() may be accessing a property or invoking a web service.

This property access utility makes this a non-issue, kind of.

## Use
One of the unit tests shows how easy it is to use.

    /**
     * Test method for {@link PropertyAsserter#assertBasicGetterSetterBehavior(Object)}
     */
    @Test
    public final void shouldAssertBasicGetterSetterBehaviorObject() {
    	PropertyAsserter.assertBasicGetterSetterBehavior(new TargetClass1());
    }

### Dependencies
1. [JUnit] to compile, test.
2. [JMockit] to run the JUnit tests for the utility itself.
3. [Gradle] or [Maven] to build.
4. [SLF4J]

Target JVM: 1.6

## Development
* IDE: Eclipse 4.3   
* OS: Windows 7 64bit Professional  
* CPU: AMD quad  

## License
The original code did not have a license, but this fork does.

This project is released under version 2.0 of the [Apache License][].

*The original author can contact me to indicate if this is not __fair use__*.

[Do You Unit Test Getters and Setters?]:https://www.altamiracorp.com/blog/employee-posts/do-you-unit-test-getters
[Apache License]: http://www.apache.org/licenses/LICENSE-2.0
[Testing getter/setter using JUnit]:http://octodecillion.com/blog/testing-gettersetter/
[JMockit]:https://code.google.com/p/jmockit/
[Gradle]:http://www.gradle.org/
[Maven]:http://maven.apache.org/
[JUnit]:http://junit.org/
[SLF4J]:http://www.slf4j.org/