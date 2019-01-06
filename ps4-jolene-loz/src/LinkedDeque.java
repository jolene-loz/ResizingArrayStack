@SuppressWarnings("unchecked")

public class LinkedDeque<T> implements Deque<T>
{

  private Node left;
  private Node right;
  private int size;

  public LinkedDeque()
  {
    this.left = null;
    this.right = null;
    this.size = 0;
  }

  private class Node<T>
  {
    private Node prev;
    private Node next;
    private T value;
  }

  public boolean isEmpty()
  {
    return left == null;
  }

  public int size()
  {
    return size;
  }

  public void pushLeft(T item)
  {
    Node<T> newNode = new Node<T>();
    newNode.value = item;

    if(this.left!=null)
    {
      newNode.next = this.left;
      this.left.prev = newNode;
    }

    this.left = newNode;
    if(this.right == null)
    {
      this.right = this.left;
    }

    this.size++;
  }
  public void pushRight(T item)
  {
    Node<T> newNode = new Node<T>();
    newNode.value = item;

    if(this.right!=null)
    {
      newNode.prev = this.right;
      this.right.next = newNode;
    }

    this.right = newNode;
    if(this.left == null)
    {
      this.left = this.right;
    }
    this.size++;
  }
  public T popLeft()
  {
    Node oldNode = this.left;
    this.left = this.left.next;

    if(this.left == null)
    {
      this.right = null;
    }

    else
    {
      left.prev = null;
    }

    this.size--;
    return (T)oldNode.value;
  }
  public T popRight()
  {
    Node oldNode = this.right;
    this.right = oldNode.prev;

    if (this.right == null)
    {
      this.left = null;
    }
    else
    {
      this.right.next = null;
    }

    this.size--;
    return (T)oldNode.value;
  }

  public String toString()
  {
    int size1 = this.size;
    StringBuilder sb = new StringBuilder();
    while (size1!=0)
    {T temp = this.popLeft();
            this.pushRight(temp);
            sb.append(temp);
            sb.append(" ");
            size1--;
        }
        return sb.toString().trim();
  }

 

  public static void main(String[] args)
  {
    System.out.println("Start Test");
    LinkedDeque<String> d = new LinkedDeque<String>();
    d.pushLeft("2");
    d.pushLeft("1");
    d.pushRight("3");
    d.pushLeft("0");
    System.out.println("Expected: 0 1 2 3"); 
    System.out.println("Actual: " + d.toString());

    d.popRight();
    System.out.println("Expected: 0 1 2"); 
    System.out.println("Actual: " + d.toString());
    d.popLeft();
    System.out.println("Expected: 1 2 "); 
    System.out.println("Actual: " + d.toString());

    System.out.println("Empty? " + d.isEmpty());
    System.out.println("Size? " + d.size());
  }
}