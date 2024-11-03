# CDOP3202 Java Programming

Author: Mohammad Rahimi Bin Zamri

## Additional Notes

### Constructor

The standard ways to handle constructor is to give default value. Method chaining using `this()` syntax have to be the first or on the most top of the constructor fields.
Example:

```
class Student {
    String name;
    String className;
    int age;

    // constructor with zero params and default value
    public Student() {
        self.name = "";
        self.className = "";
        self.age = 0;
    }

    // constructor with name and classname params, default age
    public Student(String name, String className) {
        // this is constructor chaining..
        this(name, classname, 20); // if we have other field, this should be put on the top 
        // other fields geos here
    }
}
```

reff: [java docs](http://java.sun.com/docs/books/tutorial/java/javaOO/constructors.html)

### Varags

Upon some researching, I leared that Java method can take varags. For people who doesn't know about it, the way i understand it is varags just a **placeholder** for multiple params and turn into array/list.  
Example:

```
public int sumOfNumbers(int... numbers) {  /* <--- int... numbers is varags */
    // do something
}
```

I used varags as one of Car's method.  
reff: [Baeldung](https://www.baeldung.com/java-varargs)

### Javadoc

I learn that Javadoc is the best way to explain what our codes are doing. Clear naming (method naming that explain their functionality is good), but Javadoc can clarified and explain in more details about the methods or class itself.

I tried to use Javadoc for all my _explanation comments_ in this source code.

reff: [Baeldung](https://www.baeldung.com/javadoc)

### Integer input using Scanner

Using scan.nextInt() can be dangerous, especially if we have another input after that. eg:
```
// pretend that we already have scan object
int number = scan.nextInt();
String text = scan.nextLine(); // <-- this can be dangerous
```

The reason is, when we input something to scan object, we have to press ENTER button on our keyboard and that is being read as '\n'. While `nextInt()` only read integer, guess where '\n' character will go ? It will be read into the next input prompt which is `String text = scan.nextLine()`. There's many ways that we can handle this:

1. Consume the '\n' by adding extra `scan.nextLine()` after prompting for int. This is the easiest way but could be super repeating if we have many pattern that wanted us to prompt int, string, int, string. eg: 
```
int number = scan.nextInt();
scan.nextLine() // <-- this consume the new line
String text = scan.nextLine();
```

2. We can prompt for string and can convert (type cast) into int. This is the safest way. eg:
```
int number = Integer.valueOf(scan.nextLine()); 
String text = scan.nextLine();
```