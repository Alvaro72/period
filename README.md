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
Create a Quarter:
```
Calendar cal = Calendar.getInstance();
cal.set(2018, 1, 31);
Quarter quarter = new Quarter(cal.getTime()); // First Quarter of 2018
Quarter nextTrimester = trimester.next();         // Second Quarter of 2018
Quarter previousTrimester = trimester.previous(); // Fourth Quarter of 2017
```
