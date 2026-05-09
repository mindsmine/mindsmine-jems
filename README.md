# mindsmine-jems #

## Java Extended MethodS ##

[![Maven](https://github.com/mindsmine/mindsmine-jems/actions/workflows/build.yml/badge.svg)](https://github.com/mindsmine/mindsmine-jems/actions/workflows/build.yml)

Java SDK provides ample ways to help with general coding requirements. Yet, while development, some methods for easier
manipulation of core classes are missing. **mindsmine-jems** (Java Extended MethodS) makes an attempt at providing
utility classes such as String manipulation, Object wrappers, amongst others.

---

## Developer Instructions ##

### Pre-Requisites ###

1. Java JDK, [available here](https://www.oracle.com/java/technologies/downloads/).
2. Apache Maven, [available here](http://maven.apache.org/download.cgi).

### How To Build ###

* Setup `JAVA_HOME`
```bash
$ export JAVA_HOME="path/to/Java/JDK"
```

* Setup `MAVEN_HOME`
```bash
$ export MAVEN_HOME="path/to/maven"
```

* Add `JAVA_HOME` and `MAVEN_HOME` to the terminal `PATH`
```bash
$ export PATH=${JAVA_HOME}/bin:${MAVEN_HOME}/bin:${PATH}
```

* Use `mvn` to build the project
```bash
$ mvn clean package
```

* Output `jar` file appears under the `dist` folder
* Documentation files appear under the `docs` folder
 
---

## Releases ##

**4.9.1**
* Java 26 compliant

**4.9.0**
* Java 25 compliant
* Replaced use of `java.net.URL` with `java.net.URI` instead.

**4.8.1**
* Java 20 compliant
* Using Github actions in lieu of Circle CI and Travis CI

**4.8.0**
* Removed `StringHelper.isBlank()`. Use `String#isBlank()` instead.

**4.0.1**
* Java 17 compliant

**4.0.0**
* Added Swing support methods
* Added regular expression test method
* Updated the tests code

**3.5.6**
* Java 14 compliant

**3.5.5**
* Java 12 compliant

**3.5.0**
* Added URL support methods
* Updated the tests code
* Java 10 compliant

**3.1.0**
* Added numeral system methods
* Added perfect square test method
* Added more null safe methods
* Java 9 compliant

**2.1.0**
* Added number of digits counting method
* Added unique random numbers generator method
* Added palindrome test, with leniency support
* Added string equality test, with leniency support

**2.0.0**
* Added unit representation
* Removed multiple classes and consolidated into a single class (e.g., `Number`)
* Java 8 compliant

**1.0**
* Wrappers to primitive datatypes
* Functionality most often used
* Java 7 compliant