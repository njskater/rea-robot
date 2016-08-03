# A demo robot program for REA

-------------
Design Notes:
-------------
Reading requirements, basically we need to find:
* An approach to read command
* A way invoke command to robot
* A way to store and report robot state

Following above logic, steps that I solve these requirements are roughly as follows:
1. Design basic models
2. Design Interfaces
3. Implement and test model classes
4. Implement and test command classes
5. Implement and test input classes
6. Run and test main class

Some of general rules I normally follow during design and implementation:
1. Use loosely coupled components
2. Classes with single responsibility
3. User Immutable Object whenever possible
4. Use code as document and only write necessary java docs and comments
5. Unit test meaningful components

---------------------
System Requirements
---------------------
Application tested on Mac OSX 10.10 and 10.11  
Requires:  
JDK 1.7+  
MAVEN 3.0+

------------------------------------
To run all unit tests:
------------------------------------
```
mvn clean test
```

------------------------------------
To run this application:
------------------------------------
```
./run.sh
```

---------------------------------------
Tested with following example of data:
---------------------------------------

### Example a

    PLACE 0,0,NORTH
    MOVE
    REPORT

Actual output:

    0,1,NORTH

### Example b

    PLACE 0,0,NORTH
    LEFT
    REPORT

Actual output:

    0,0,WEST

### Example c

    PLACE 1,2,EAST
    MOVE
    MOVE
    LEFT
    MOVE
    REPORT

Actual output

    3,3,NORTH