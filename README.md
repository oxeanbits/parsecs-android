# parsecs-android

A parser android library for Math equations using a lighter, faster and more complete version of muparserx C++ library
 
## Usage

#### Add to your `build.gradle`

```groovy
implementation "com.github.niltonvasques:parsecs-android:0.2.+"
```

## Run

```sh
./gradlew clean assembleDebug
```

#### You can then eval equations in your code one by one

```kotlin
val parser = Parsec()
parser.evalValue('5 + 1').getValue()
parser.evalValue('(3 + 3) * (5 * 2)').getValue()
```

#### You can also eval many equations at once

```kotlin
val parser = Parsec()
val results = parser.evalValues(listOf('5 + 1', 'sin(43)', 'log(10)'))
```

#### Here are examples of equations which are accepted by the parser
```sh
val parser = Parsec().getValue()

# Simple Math equations
parser.evalValue('(5 + 1) + (6 - 2)').getValue()  # result => 10
parser.evalValue('4 + 4 * 3').getValue()          # result => 16
parser.evalValue('10.5 / 5.25').getValue()        # result => 2
parser.evalValue('abs(-5)').getValue()            # result => 5
parser.evalValue('sqrt(16) + cbrt(8)').getValue() # result => 6
parser.evalValue('log10(10)').getValue()          # result => 1
parser.evalValue('round(4.4)').getValue()         # result => 4
parser.evalValue('(3^3)^2').getValue()            # result => 729
parser.evalValue('3^(3^(2))').getValue()          # result => 19683
parser.evalValue('10!').getValue()                # result => 3628800
parser.evalValue('string(10)').getValue()         # result => "10"

# Complex Math equations
parser.evalValue('log10(10) + ln(e) + log(10)').getValue()       # result => 4.30259
parser.evalValue('sin(1) + cos(0) + tan(0.15722)').getValue()    # result => 2.0
parser.evalValue('max(1, 2) + min(3, 4) + sum(5, 6)').getValue() # result => 16
parser.evalValue('avg(9, 9.8, 10)').getValue()                   # result => 9.6
parser.evalValue('pow(2, 3)').getValue()                         # result => 8
parser.evalValue('round_decimal(4.559, 2)').getValue()           # result => 4.56

# IF THEN ELSE equations
parser.evalValue('4 > 2 ? "bigger" : "smaller"').getValue()    # result => "bigger"
parser.evalValue('2 == 2 ? true : false').getValue()           # result => true
parser.evalValue('2 != 2 ? true : false').getValue()           # result => false
parser.evalValue('"this" == "this" ? "yes" : "no"').getValue() # result => "yes"
parser.evalValue('"this" != "that" ? "yes" : "no"').getValue() # result => "yes"

# Logic equations
parser.evalValue('true and false').getValue()    # result => false
parser.evalValue('true or false').getValue()     # result => true
parser.evalValue('(3==3) and (3!=3)').getValue() # result => false
parser.evalValue('exp(1) == e').getValue()       # result => true

# String equations
parser.evalValue('length("test string")').getValue()     # result => 11
parser.evalValue('toupper("test string")').getValue()    # result => "TEST STRING"
parser.evalValue('tolower("TEST STRING")').getValue()    # result => "test string"
parser.evalValue('concat("Hello ", "World")').getValue() # result => "Hello World"
parser.evalValue('link("Title", "http://foo.bar")').getValue() # result => "<a href="http://foo.bar">Title</a>"
parser.evalValue('str2number("5")').getValue()           # result => 5
parser.evalValue('left("Hello World", 5)').getValue()    # result => "Hello"
parser.evalValue('right("Hello World", 5)').getValue()   # result => "World"
parser.evalValue('number("5")').getValue()               # result => 5

# Date equations (return the difference in days).getValue()
parser.evalValue("current_date()")).getValue()                        # result => "2018-10-03"
parser.evalValue('daysdiff(current_date(), "2018-10-04")').getValue() # result => 1
parser.evalValue('daysdiff("2018-01-01", "2018-12-31")').getValue()   # result => 364

# DateTime equations (return the difference in hours).getValue()
parser.evalValue('hoursdiff("2018-01-01", "2018-01-02")').getValue()             # result => 24
parser.evalValue('hoursdiff("2019-02-01T08:00", "2019-02-01T12:00")').getValue() # result => 4
parser.evalValue('hoursdiff("2019-02-01T08:20", "2019-02-01T12:00")').getValue() # result => 3.67
parser.evalValue('hoursdiff("2018-01-01", "2018-01-01")').getValue()             # result => 0
```

### The following functions can be used

* Math trigonometric functions: **sin**, **cos**, **tan**, **sinh**, **cosh**, **tanh**, **asin**, **acos**, **atan**, **asinh**, **acosh**, **atanh**
* Math logarithm functions: **ln**, **log**, **log10**
* Math standard functions: **abs**, **sqrt**, **cbrt**, **pow**, **exp**, **round**, **round_decimal**
* Number functions: **string**
* Math constants: **e**, **pi**
* Unlimited number of arguments: **min**, **max**, **sum**, **avg**
* String functions: **concat**, **length**, **toupper**, **tolower**, **left**, **right**, **str2number**, **number**, **link**
* Complex functions: **real**, **imag**, **conj**, **arg**, **norm**
* Array functions: **sizeof**, **eye**, **ones**, **zeros**
* Date functions: **current_date**, **daysdiff**, **hoursdiff**
* Extra functions: **default_value**
