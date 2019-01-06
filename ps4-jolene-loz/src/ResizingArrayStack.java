
import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.*;

/**
 *  The <tt>ResizingArrayStack</tt> class represents a last-in-first-out (LIFO) stack
 *  of generic items.
 *  It supports the usual <em>push</em> and <em>pop</em> operations, along with methods
 *  for peeking at the top item, testing if the stack is empty, and iterating through
 *  the items in LIFO order.
 *  <p>
 *  This implementation uses a resizing array, which double the underlying array
 *  when it is full and halves the underlying array when it is one-quarter full.
 *  The <em>push</em> and <em>pop</em> operations take constant amortized time.
 *  The <em>size</em>, <em>peek</em>, and <em>is-empty</em> operations takes
 *  constant time in the worst case.
 *  <p>
 *  For additional documentation, see <a href="/algs4/13stacks">Section 1.3</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin author.
 *
 *  @Wayne Robert Sedgewick
 *  @author Kevin Wayne
 */
public class ResizingArrayStack<T>{
    private T[] a;            // array of items
    private int N;            // number of elements on stack


    /**
     * Initializes an empty stack.
     */
    public ResizingArrayStack() {
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[2];
        this.a = temp;
    }

    /**
     * Is this stack empty?
     * @return true if this stack is empty; false otherwise
     */
    public boolean isEmpty() { return this.N == 0; }

    /**
     * Returns the number of items in the stack.
     * @return the number of items in the stack
     */
    public int size() { return this.N; }

    // resize the underlying array holding the elements
    private void resize(int capacity) {
        assert capacity >= this.N;

        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[capacity];
        for (int i = 0; i < this.N; i++)
            temp[i] = a[i];
        this.a = temp;
    }

    /**
     * Adds the item to this stack.
     * @param item the item to add
     */
    public void push(T item) {
        if (this.N == a.length) resize(2 * a.length);    // double size of array if necessary
        a[this.N++] = item;                              // add item
    }

    /**
     * Removes and returns the item most recently added to this stack.
     * @return the item most recently added
     * @throws java.util.NoSuchElementException if this stack is empty
     */
    public T pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        T item = a[N-1];
        a[N-1] = null;                              // to avoid loitering
        N--;
        // shrink size of array if necessary
        if (N > 0 && N == a.length / 4) resize(a.length / 2);
        return item;
    }


    /**
     * Returns (but does not remove) the item most recently added to this stack.
     * @return the item most recently added to this stack
     * @throws java.util.NoSuchElementException if this stack is empty
     */
    public T peek() {
        if (this.isEmpty())
          throw new NoSuchElementException("Stack underflow");
        return this.a[N - 1];
    }

    public String toString() {

      String ans = "stack: ";
      for (int i = 0; i < this.N; i++)
        ans = ans + this.a[i] + " ";
      return ans;
    }

    /**
     * Unit tests the <tt>Stack</tt> data type.
     */
    public static void main(String[] args) {
        ResizingArrayStack<String> s = new ResizingArrayStack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");

    }
}