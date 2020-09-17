/**
 * Node definition for a binary tree
 */
class Node
{
  private Node left;
  private Node right;
  private int value;

  public Node(int value)
  {
    this.value = value;
    left = null;
    right = null;
  }

  /**
   * @return the left
   */
  public Node getLeft() {
    return left;
  }

  /**
   * @return the right
   */
  public Node getRight() {
    return right;
  }

  /**
   * @return the value
   */
  public int getValue() {
    return value;
  }

  /**
   * @param left the left to set
   */
  public void setLeft(Node left) {
    this.left = left;
  }

  /**
   * @param right the right to set
   */
  public void setRight(Node right) {
    this.right = right;
  }
}
