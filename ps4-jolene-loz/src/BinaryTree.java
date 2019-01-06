/* BinaryTree.java */

package dict; 

/**
 *  BinaryTree implements a Dictionary as a binary tree (unbalanced).
 *
 *  DO NOT CHANGE ANY PROTOTYPES IN THIS FILE.
 **/
public class BinaryTree implements Dictionary {

  /** 
   *  size is the number of items stored in the dictionary.
   *  root is the BinaryTreeNode that serves as root of the tree.  If there
   *    are no items (size is zero), root is null.
   **/
  protected int size;
  protected BinaryTreeNode root;

  public BinaryTree() {
    makeEmpty();
  }

  /** 
   *  Returns the number of items stored in the dictionary, where each item
   *  is counted according to its multiplicity.
   *  @return number of items in the dictionary.
   **/
  public int size() {
    return size;
  }

  /** 
   *  Tests if the dictionary is empty.
   *
   *  @return true if the dictionary has no items, false otherwise.
   **/
  public boolean isEmpty() {
    return size == 0;
  }

  /** 
   *  Insert an item (a key and an associated element).  Multiple items with
   *  the same key can coexist in the dictionary.
   *
   *  @param key the key by which the item can be retrieved.
   *  @param element an arbitrary object.
   **/
  public void insertItem(Object key, Object element) {
    if (root == null) {
      root = new BinaryTreeNode((Comparable) key, element);
      size++;
    } else {
      insertItemHelper((Comparable) key, element, root);
    }
  }

  private void insertItemHelper(Comparable key, Object element, 
                                BinaryTreeNode node) {
    if (key.compareTo(node.key) <= 0) {
      if (node.leftChild == null) {
 node.leftChild = new BinaryTreeNode(key, element, node);
 size++;
      } else {
 insertItemHelper(key, element, node.leftChild);
      }
    } else {
      if (node.rightChild == null) {
 node.rightChild = new BinaryTreeNode(key, element, node);
 size++;
      } else {
 insertItemHelper(key, element, node.rightChild);
      }
    }
  }

  /** 
   *  Search for an item with the specified key.  If such an item is found,
   *  return its element; otherwise return the special element NO_SUCH_KEY.
   *  If several items have the specified key, one is chosen arbitrarily and
   *  returned.
   *
   *  @param key the search key.
   *  @return element an element associated with the key, or NO_SUCH_KEY if no
   *  item is associated with the specified key.
   **/
  public Object findElement(Object key) {
    BinaryTreeNode node = findElementHelper((Comparable) key, root);
    if (node == null) {
      return NO_SUCH_KEY;
    } else {
      return node.element;
    }
  }

  /**
   *  Search for a node with the specified key, starting from "node".  If a
   *  matching key is found (meaning that key1.compareTo(key2) == 0), return
   *  a node containing that key.  Otherwise, return null.
   *
   *  Be sure this method returns null if node == null.
   **/
  private BinaryTreeNode findElementHelper(Comparable key,
                                           BinaryTreeNode node) {
    // Replace the following line with your solution.
    return null;
  }

  /** 
   *  Remove an item with the specified key.  If such an item is found, return
   *  its element and remove it from the table; otherwise else return the
   *  special element NO_SUCH_KEY.  If several items have the specified key,
   *  one is chosen arbitrarily, removed, and returned.
   *
   *  @param key the search key.
   *  @return element an element associated with the key, or NO_SUCH_KEY if no
   *  item is associated with the specified key.
   **/
  public Object remove(Object key) {
    // Replace the following line with your solution.
    return null;
  }

  /**
   *  Remove all items from the dictionary.
   **/
  public void makeEmpty() {
    size = 0;
    root = null;
  }

  /**
   *  Convert the tree into a string.
   **/
  public String toString() {
    if (root == null) {
      return "";
    } else {
      return root.toString();
    }
  }

  /* Tests the binary tree. */
  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();

    System.out.println("Inserting 1A, 6V, 3K, 2Z, 5L, 9L:");
    tree.insertItem(new Integer(1), "A");
    tree.insertItem(new Integer(6), "V");
    tree.insertItem(new Integer(3), "K");
    tree.insertItem(new Integer(2), "Z");
    tree.insertItem(new Integer(5), "L");
    tree.insertItem(new Integer(9), "L");
    System.out.println("The tree is:  " + tree);
    System.out.println("Size:  " + tree.size());

    System.out.println("\nTesting findElement ...");
    testFind(tree, 1, "A");
    testFind(tree, 9, "L");
    testFind(tree, 5, "L");
    testFind(tree, 4, "Dictionary.NO_SUCH_KEY");
    testFind(tree, 6, "V");
    testFind(tree, 3, "K");

    System.out.println("\nTesting remove (for nodes with < 2 children) ...");
    testRemove(tree, 5, "1A(((2Z)3K)6V(9L))");
    testRemove(tree, 3, "1A((2Z)6V(9L))");
    testRemove(tree, 1, "(2Z)6V(9L)");
    tree.insertItem(new Integer(7), "S");
    tree.insertItem(new Integer(8), "X");
    tree.insertItem(new Integer(10), "B");
    System.out.println("After inserting 7S, 8X, 10B:  " + tree);
    System.out.println("Size:  " + tree.size());
    if (tree.size() != 6) {
      System.out.println("  SHOULD BE 6.");
    }

    System.out.println("\nTesting remove (for nodes with 2 children) ...");
    testRemove(tree, 6, "(2Z)7S((8X)9L(10B))");
    testRemove(tree, 9, "(2Z)7S((8X)10B)");
    System.out.println("Size:  " + tree.size());
    if (tree.size() != 4) {
      System.out.println("  SHOULD BE 4.");
    }
  }

  private static void testRemove(BinaryTree tree, int n, String shouldBe) {
    Integer key = new Integer(n);
    System.out.print("After remove " + n + ":  ");
    tree.remove(key);
    System.out.println(tree);
    if (!tree.toString().equals(shouldBe)) {
      System.out.println("  SHOULD BE " + shouldBe);
    }
  }

  private static void testFind(BinaryTree tree, int n, Object truth) {
    Integer key = new Integer(n);
    Object element = tree.findElement(key);
    System.out.println("Calling findElement on " + n);
    System.out.println("  returned " + element + ".");
    if (!element.equals(truth)) {
      System.out.println("  SHOULD BE " + truth + ".");
    }
  }
  
}