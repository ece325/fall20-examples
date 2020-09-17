/**
 * 
 */
public class BinarySearchTree
{
  // BST root
  private Node root;

  /**
   * Default constructor
   */
  public BinarySearchTree()
  {
    root = null;
  }

  /**
   * Helper method to insert a value in a subtree
   * @param root of the subtree to insert the given value
   * @param value to insert
   */
  private void insertHelper(Node root, int value)
  {
    if (value <= root.getValue()) {
      Node left = root.getLeft();
      if (left==null) {
        root.setLeft(new Node(value));
      } else {
        insertHelper(left, value);
      }
    } else {
      Node right = root.getRight();
      if (right==null) {
        root.setRight(new Node(value));
      } else {
        insertHelper(right, value);
      }
    }
  }

  /**
   * Inserts the given value in the right place inside the BST
   * @param value to insert
   */
  public void insert(int value)
  {
    if (root==null) {
      root = new Node(value);
    } else {
      insertHelper(root, value);
    }
  }

  /**
   * A helper method to produce a string with the subtree hierarchy referenced by the giver root
   * @param root of the subtree to print
   * @param space used to separate the subtree
   * @return A string to show the BST hierarchy
   */
  String printTree(Node root, String space)
  {
    if (root==null)
      return "";
    return space + root.getValue() + "\n" +
           printTree(root.getLeft(),space+"  ") + "\n" +
           printTree(root.getRight(),space+"  ");
  }

  /**
   * Prints the BST
   */
  public void printTree()
  {
    System.out.println(printTree(this.root,""));
  }
}