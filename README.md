
# Lab 08: ADT - Graph Implementation and Testing

## Introduction

This lab focuses on designing, testing, and implementing abstract data types (ADTs). The primary task involves creating a mutable weighted directed graph ADT with labeled vertices, specifically Graph<String>.

## Group Members

- Member 1: Zubair Khalid
- Member 2: Shahmeer Sheraz
- Member 3: Nimra Arif
- Member 4: Saddam Hussain

**Distribution of Work:**

| Task                         | Member Responsible  |
| ---------------------------- | ------------------- |
| Shahmeer Sheraz              | Wrote the Test Cases for the Abstract Class GraphInstanceTest.java and the Class GraphStatic Test.java |
| Nimra Arif                   | Wrote and ran the test cases for Concrete EdgesGraphTest.java class and ConcreteVerticesGraphTest.java class.   |
| Saddam Hussain               | Wrote the code for Concrete EdgesGraph.java and ConcreteVetricesGraph.java    |
| Zubair Khalid                | Wrote the code for Graph.java   |


## Task Descriptions

### Problem 1: Test Graph<String>

#### Task 1.1: Write Tests for Graph<String>

- **File:** `GraphStaticTest.java`
- **Description:** We have Devised, documented, and implemented tests for the `Graph<String>` ADT. Ensured that the tests were legal clients of the Graph spec.
- **Note:** We Used the `emptyInstance()` method to obtain fresh empty graphs, not `Graph.empty()`. See the provided `testInitialVerticesEmpty()` for an example.

### Problem 2: Implement Graph<String>

#### Task 2.1: Implement ConcreteEdgesGraph

- **Files:** 
  - `ConcreteEdgesGraph.java`
  - `ConcreteEdgesGraphTest.java`
  - `Edge.java`
- **Description:** We have implemented the `ConcreteEdgesGraph` class using the provided representation. We Designed the specification and representation for the `Edge` class, ensuring it is immutable. Devised, documented, and implemented tests for the `Edge` class in `ConcreteEdgesGraphTest.java`.

#### Task 2.2: Implement ConcreteVerticesGraph

- **Files:** 
  - `ConcreteVerticesGraph.java`
  - `ConcreteVerticesGraphTest.java`
  - `Vertex.java`
- **Description:** We have implemented the `ConcreteVerticesGraph` class using the provided representation. We designed the specification and representation for the `Vertex` class, ensuring it is mutable. Devised, documented, and implemented tests for the `Vertex` class in `ConcreteVerticesGraphTest.java.


### Conclusion

The project successfully implements and tests the `Graph<L>` ADT for mutable weighted directed graphs with labeled vertices. The design adheres to abstraction functions, representation invariants, and encapsulation principles, ensuring the reliability and correctness of the implementation.









