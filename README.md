# period
Java library for working with periods between dates.

# Maven
For use with maven add this dependency.
```
    <dependency>
      <groupId>me.alsagui</groupId>
      <artifactId>period</artifactId>
      <version>0.8.1</version>
    </dependency>
```

# Examples
Create a Trimester:
```
Calendar cal = Calendar.getInstance();
cal.set(2018, 1, 31);
Trimester trimester = new Trimester(cal.getTime()); // First Trimester of 2018
Trimester nextTrimester = trimester.next();         // Second Trimester of 2018
Trimester previousTrimester = trimester.previous(); // Fourth Trimester of 2017
```
