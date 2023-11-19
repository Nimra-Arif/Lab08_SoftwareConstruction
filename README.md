
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

### Project Structure

The project is organized into the following components:

1. **Implementation Code:**
   - `Graph.java`: Implementation of the `Graph<L>` ADT for mutable weighted directed graphs with labeled vertices.
   - `GraphInstanceTest.java`: Unit tests for instance methods of the `Graph<L>` ADT.
   - `GraphStaticTest.java`: Unit tests for the static `Graph.empty()` method.

2. **Test Code:**
   - `GraphInstanceTest.java`: Contains tests for instance methods using the `emptyInstance()` method to obtain fresh empty graphs.

### Task Descriptions

#### Task 1: Test Graph<String>

- **Completion Status:** Completed
- **Summary:** Tests for the static `Graph.empty()` method are provided in `GraphStaticTest.java`. Tests for all instance methods are documented and implemented in `GraphInstanceTest.java`. The `emptyInstance()` method is used to obtain fresh empty graphs for testing.

#### Task 2: Implement Graph<String> - Twice

- **Completion Status:** Completed
- **Summary:**
  - Implemented the `Graph<String>` ADT as specified in the problem set.
  - Documented the abstraction function and representation invariant for each class.
  - Described how each class prevents rep exposure.
  - Implemented the `checkRep` method to verify the representation invariant.
  - Implemented the `toString` method to provide a human-readable representation of the abstract value.


### Conclusion

The project successfully implements and tests the `Graph<L>` ADT for mutable weighted directed graphs with labeled vertices. The design adheres to abstraction functions, representation invariants, and encapsulation principles, ensuring the reliability and correctness of the implementation.



