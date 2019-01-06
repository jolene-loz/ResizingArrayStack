public interface Deque<T> {
  void pushLeft(T item);
  T popLeft();
  void pushRight(T item);
  T popRight(); 
  int size();
  boolean isEmpty();
  String toString();
}
