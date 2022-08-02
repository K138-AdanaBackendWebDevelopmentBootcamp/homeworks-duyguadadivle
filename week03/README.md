# DESIGN PATTERN

In software, a design pattern is a general repeatable solution to a commonly occurring problem in software design. A design pattern isn't a finished design that can be transformed directly into code. It is a description or template for how to solve a problem that can be used in many different situations.


### USES OF DESIGN PATTERN
Design patterns can accelerate the development process by providing tested, proven development paradigms. Effective software design requires consideration of issues that may not become visible later in the application. Reusing design patterns helps prevent subtle issues that can cause major problems and improves code readability for coders and architects familiar with patterns.

Oftentimes, people only understand how to apply certain software design techniques to certain problems. These techniques are difficult to apply to a wider range of problems. Design patterns provide general solutions to a particular problem that are documented in a way that does not require specific features.

Patterns also allow developers to communicate using well-known, well-understood names for software interactions. Common design patterns can be developed over time, making them more robust than ad-hoc designs.

### Creational design patterns
These design patterns are all about class instantiation. This pattern can be further divided into class-creation patterns and object-creational patterns. While class-creation patterns use inheritance effectively in the instantiation process, object-creation patterns use delegation effectively to get the job done.

1- Abstract Factory \
Creates an instance of several families of classes \
2- Builder \
Separates object construction from its representation \
3- Factory Method \
Creates an instance of several derived classes \
4- Object Pool \
Avoid expensive acquisition and release of resources by recycling objects that are no longer in use \
5- Prototype \
A fully initialized instance to be copied or cloned \
6- Singleton \
A class of which only a single instance can exist 
 <hr/> 


## Structural design patterns
These design patterns are all about Class and Object composition. Structural class-creation patterns use inheritance to compose interfaces. Structural object-patterns define ways to compose objects to obtain new functionality. \
1- Adapter \
Match interfaces of different classes \
2- Bridge \
Separates an object’s interface from its implementation \
3- Composite \
A tree structure of simple and composite objects \
4- Decorator \
Add responsibilities to objects dynamically \
5- Facade \
A single class that represents an entire subsystem \
6- Flyweight \
A fine-grained instance used for efficient sharing \
7- Private Class Data \
Restricts accessor/mutator access \
8- Proxy \
An object representing another object 

<hr/>

## Behavioral design patterns
These design patterns are all about Class's objects communication. Behavioral patterns are those patterns that are most specifically concerned with communication between objects. 

1- Chain of responsibility \
A way of passing a request between a chain of objects \
2- Command \
Encapsulate a command request as an object \
3- Interpreter \
A way to include language elements in a program \
4- Iterator \
Sequentially access the elements of a collection \
5- Mediator \
Defines simplified communication between classes \
6- Memento
Capture and restore an object's internal state \
7- Null Object \
Designed to act as a default value of an object \
8- Observer \
A way of notifying change to a number of classes \
9- Strategy \
Encapsulates an algorithm inside a class \
10- Template method \
Defer the exact steps of an algorithm to a subclass \
11- Visitor \
Defines a new operation to a class without change 
<br/>


### Why Singleton Is Used
The Singleton's purpose is to control object creation, limiting the number of objects to only one. Since there is only one Singleton instance, any instance fields of a Singleton will occur only once per class, just like static fields. 

### Why Facade Is Used
A Facade is used when an easier or simpler interface to an underlying object is desired. Alternatively, an adapter can be used when the wrapper must respect a particular interface and must support polymorphic behavior. A decorator makes it possible to add or alter behavior of an interface at run-time. 

### Why Strategy Is Used
Strategy is important because the resources available to achieve goals are usually limited. Strategy generally involves setting goals and priorities, determining actions to achieve the goals, and mobilizing resources to execute the actions. 

