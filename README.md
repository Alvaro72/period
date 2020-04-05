# period
Java library for working with periods between dates.

# Maven
For use with maven add this dependency.
```
    <dependency>
      <groupId>com.github.alvaro72</groupId>
      <artifactId>period</artifactId>
      <version>0.9.23</version>
    </dependency>
```

# Examples
Create a Quarter:
```
Calendar cal = Calendar.getInstance();
cal.set(2018, 1, 31);
Quarter quarter = new Quarter(cal.getTime()); // First Quarter of 2018
Quarter nextQuarter = quarter.next();         // Second Quarter of 2018
Quarter previousQuarter = quarter.previous(); // Fourth Quarter of 2017
```
