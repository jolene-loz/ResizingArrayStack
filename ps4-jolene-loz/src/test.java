
public class test {
  

  
  public static void getMin (int[] array) {
    int min = 100;
    for (int i = 0; i < array.length; i++) {
      if (array[i]<min) {
        min = array[i];
      }
    }
    System.out.print(min);
  }
  
  
  public static void main (String[] args) {
    int[] array = new int[3];
    array[0] = 1;
    array[1] = 2;
    array[2] = 0;
    getMin(array);
  }
}