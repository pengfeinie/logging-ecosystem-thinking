## The Java Logging Ecosystem

If you’re new to Java and have a background in a platform such as Python, one of the first things that you will notice is the large number of logging frameworks that are available and remain used today. To understand why so many different frameworks exist, we’ll start with a quick history lesson.

![image](https://images.ctfassets.net/em6l9zw4tzag/6Ge4VdwNwbfjtloOLwp05c/145c1c477ed6aed78e408e3f5cbed77b/java-logging-timeline.png)

Log4j was introduced in 1999 and was one of the first widely adopted logging frameworks. A few years later in 2002, Sun introduced an alternative framework, java.util.logging (commonly referred to by the acronym “JUL”), which is distributed with the Java platform. In reaction, the Apache Commons Logging project was created with the intention of providing a unified logging API that could be used to interact with whichever backing logging implementation that the user preferred, including Log4j and JUL (among others.) However, yet another alternative “unified” logging API emerged in 2005 from the author of Log4j — SLF4J, the “Simple Logging Facade for Java.” Later, the author of Log4j and SLF4J released logback, which provided a native implementation of the SLF4J interface. Around the same time, development also began on the (now stable) Log4j 2 — without the author of the first version. Simple, right?

There was a lot of code that was written at different points in time during this history and like so much software there was — and still is — lot of debates on which framework is the best choice.

## Reference

https://blog.sentry.io/2016/01/28/capturing-java-exceptions
