public class ResizingArrayDeque<T>implements Deque<T>{
  private int top;
  private T[] myDeque;
  
  public DequeC(){
    deque = new DequeC<T>();
  }
  public void pushLeft(T item){
    
  };
  public T popLeft(){
  };
  public void pushRight(T item);
  public T popRight(){
  };
  public int size(){
    return this.top;
  }
  public boolean isEmpty(){
    return this.top == 0;
  }
  public String toString(){
    StringBuilder sb = new StringBuilder();
    for(int i = this.top - 1; i >= 0; i--){
          sb.append(this.myStack[i].toString() + "\n");
    }
    return sb.toString();
  }
  private void resize(int capacity) {
    Item[] temp = (Item[]) new Object[capacity];
    for (int i = 0; i < n; i++)
      temp[i] = q[(first + i) % q.length];
    q = temp;
    first = 0;
    last  = n;
  }
  public static void main(String[] args){
    DequeC deque = new DequeC<>();
    while(!myDeque.isEmpty()){
    }
    
  }
}
