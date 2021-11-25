## The Java Logging Ecosystem

If you’re new to Java and have a background in a platform such as Python, one of the first things that you will notice is the large number of logging frameworks that are available and remain used today. To understand why so many different frameworks exist, we’ll start with a quick history lesson.

![image](https://images.ctfassets.net/em6l9zw4tzag/6Ge4VdwNwbfjtloOLwp05c/145c1c477ed6aed78e408e3f5cbed77b/java-logging-timeline.png)

Log4j was introduced in 1999 and was one of the first widely adopted logging frameworks. A few years later in 2002, Sun introduced an alternative framework, java.util.logging (commonly referred to by the acronym “JUL”), which is distributed with the Java platform. In reaction, the Apache Commons Logging project was created with the intention of providing a unified logging API that could be used to interact with whichever backing logging implementation that the user preferred, including Log4j and JUL (among others.) However, yet another alternative “unified” logging API emerged in 2005 from the author of Log4j — SLF4J, the “Simple Logging Facade for Java.” Later, the author of Log4j and SLF4J released logback, which provided a native implementation of the SLF4J interface. Around the same time, development also began on the (now stable) Log4j 2 — without the author of the first version. Simple, right?

There was a lot of code that was written at different points in time during this history and like so much software there was — and still is — lot of debates on which framework is the best choice.

## Think again before adopting the commons-logging API

### Introduction

Given that log4j is such a low-level library, most organizations are hesitant to tie their code to log4j, especially considering the new logging API included in JDK 1.4. Before going forward, it is appropriate to mention that these two APIs are very similar. The classical usage pattern for log4j is:

```java
import org.apache.log4j.Logger;

public class MyClass {
  final static Logger logger = Logger.getLogger("some.name");

   public void foo1() {
     logger.debug("Hello world.");
   }

   public void foo2() {
     logger.info("Another message.");
     logger.error("Stop that!", 
                   new Exception("The earth is getting warmer."));
   }
}
```

As you are well aware by now, one of the important benefits of log4j is that it can be configured at run time using configuration scripts. You can have hundreds or thousands of log statement but only one or two lines of Java code to configure log4j. The usage pattern for the JDK 1.4 logging API is:

```java
import java.util.logging.Logger;

public class MyClass {
   final static Logger logger = Logger.getLogger("test"); 

   public void foo1() {
     logger.debug("Hello world.");
   }

   public void foo2() {
     logger.info("Another message.");
     logger.error("Stop that!", 
                   new Exception("The earth is getting warmer."));
   }
}
```

Although the log4j API is at least two years older than JDK 1.4, notice the extent to which the two APIs are similar. The JDK 1.4 logging API also supports configuration scripts. Being part of the JDK, some users reckon that the JSR47 API will supplant log4j some time in the near future. Surprisingly enough, it is not easy to write a complete logging API. Users come to realize they need the features present in log4j but absent in JDK 1.4 logging. Moreover, log4j runs under JDK 1.1 or later whereas JDK 1.4 logging requires, well, JDK 1.4. Most users can't afford to tie their code to JDK 1.4. But they need logging and they need it now. A common strategy for protecting against future changes and at the same time to benefit from existing log4j features is to wrap log4j with a custom logging API. Log4j actually has support to facilitate such wrappers.

Although not particularly difficult, it turns out that wrappers are not trivial to write. I frequently receive email where a user runs into a problem with their wrapper and requests help. More often than not, these wrappers are of doubtful quality such that the cost of inactive (or disabled) logging statements is multiplied by a factor of 1'000 (one thousand) compared to direct log4j usage. The most common error in wrapper classes is the invocation of the `Logger.getLogger` method on each log request. This is guaranteed to wreak havoc on your application's performance. Really!!!

Of course, not all wrappers are of poor quality. For example, the commons-logging API is a prime example of a reasonable implementation. The commons-logging API will try to use different logging frameworks depending on their presence on the class path. See [commons-logging](http://commons.apache.org/logging/) project for more details. Obviously, even a good wrapper will carry a small overhead but that is not the point. The aspect where most users have difficulty is the initialization of the log4j API. Where should *log4j.jar* go? Where do I put the *log4j.properties* file? Can different web-applications have different log4j configurations? How do I initialize log4j in an application server? Although there is ample literature on the subject, much confusion remains.





## Reference

- https://blog.sentry.io/2016/01/28/capturing-java-exceptions
- http://articles.qos.ch/thinkAgain.html
- https://spring.io/blog/2009/12/04/logging-dependencies-in-spring/
