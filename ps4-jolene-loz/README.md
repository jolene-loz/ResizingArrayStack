# CSCI 1102 Computer Science 2

### Spring 2018

------

## Problem Set 4 : Deques

### 10 Points

### Due Sunday February 18, 2018 Midnight

This is a variation of problem 1.3.33 of SW. Implement the Deque ADT.

```java
public interface Deque<T> {

  void pushLeft(T item);
  void pushRight(T item);
  T popLeft();
  T popRight();
  int size();
  boolean isEmpty();
  String toString();
}
```

In this problem set, you are to design and implement two classes implementing the above API. One class should be called `LinkedDeque<T>` and should use a doubly-linked list to implement the API. The other class should be called `ResizingArrayDeque<T>` and it should implement the API using a resizing array.

Following our usual practice, each implementation class should contain `main` functions that create values of type `Deque<T>` for testing purposes.