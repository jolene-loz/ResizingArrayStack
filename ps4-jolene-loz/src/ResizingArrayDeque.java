import java.util.NoSuchElementException;
@SuppressWarnings("unchecked")

public class ResizingArrayDeque<T> implements Deque<T>{
  private int size;
  private T[] myDeque;
  private int left;
  private int right;
  private int length= 2;
  
  public ResizingArrayDeque(){
    this.myDeque = (T[]) new Object[length];
    //initialize values
    this.size = 0;
    this.left = 0;
    this.right = 0;
  }  
  
  //Textbook implementation of resize function
  private void resize(int capacity) {
    T[] temp = (T[]) new Object[capacity];
    for (int i = 0; i < size; i++) {
      temp[i] = myDeque[i];
    }
    myDeque = temp;
    left = 0;
    right = size;
  }
  
  public void pushLeft(T item){
      if (size == myDeque.length) //resize if needed
            resize(2*this.myDeque.length);
        if (left == 0) {
            left = this.myDeque.length-1;
            myDeque[left] = item;
        }
        else {
            left--; //subtract to get leftmost index value
            myDeque[left] = item; //assign item to the leftmost index value
        }
        this.size++;
  }
  
  
  public T popLeft(){
    if (isEmpty()){
      throw new NoSuchElementException("Deque underflow");
    }
    if (left == myDeque.length) {
      left = 0; 
    }   
    if (size > 0 && size == myDeque.length/4){
      resize(myDeque.length/2);
    }
    T leftMost = this.myDeque[left];
    myDeque[left] = null; //pop value by setting equal to null
    size--; 
    left++; 
    return leftMost;
  }
  
  public T popRight(){
    if (isEmpty()){
      throw new NoSuchElementException("Deque underflow");
    }
    T rightMost = myDeque[right];
    if (right == 0){
      right = myDeque.length-1; //Wrap to last}
    }
    else{ 
      right--;}
    this.size--;    
    if (size > 0 && size == myDeque.length/4){
      resize(myDeque.length/2);
    }
    return rightMost;
  }
  
  public void pushRight(T item){
    if (size == myDeque.length){
      resize(2*myDeque.length);
    }
    myDeque[right++] = item;
    if (right == myDeque.length){
            right = 0; //Wrap it around
    }
    this.size++;
    }
  public int size(){
    return size;
  }
  public boolean isEmpty(){
    return size == 0;
  }
  public String toString() {  
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < size; i++){
      sb.append((this.myDeque[i + left] + " "));
    }
    return sb.toString().trim();
  }
  
 public int getMinValue() {
    int minValue = new int;
    for (int i = 0; i < myDeque.length; i++) {
        if (myDeque[i] < (int)minValue) {
            minValue = myDeque[i];
        }
    }
    return minValue;
}

  public static void main(String [] args){
    ResizingArrayDeque<Integer> d = new ResizingArrayDeque<Integer>();
    d.pushLeft(7);  
    d.pushLeft(10); 
    d.pushRight(1);
    d.pushRight(5);
    System.out.println("Expected: 10 7 1 5");
    System.out.println("Actual: " + d.toString());
    d.popLeft();
    d.popRight();
    System.out.println("Expected: 7 1 ");
    System.out.println("Actual: " + d.toString());
    System.out.println("Empty? " + d.isEmpty());
    System.out.println("Final size? " + d.size());
    System.out.println("Minimum: " + d.getMinValue());
    
  }
}
