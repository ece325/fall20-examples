public class BinaryTree 
{
  /**
   * Computes the index (position) of the left child of the given node position
   * @param i node position
   * @return index of the left child
   */
  static int leftChild(int i) {
    return i*2+1;
  }

  /**
   * Computes the index (position) of the right child of the given node position
   * @param i node position
   * @return index of the right child
   */
  static int rightChild(int i) {
    return i*2+2;
  }

  /**
   * Prints the depth first traversal from the given tree using inorder traversal
   * starting on the given node index
   * @param tree binary tree to traverse
   * @param root starting node index
   */
  static void depthFirstTraversal(int[] tree, int root) {
    int size = tree.length;
    if (root<size) { 
      int left = leftChild(root);
      int right = rightChild(root);
      depthFirstTraversal(tree, left);
      depthFirstTraversal(tree, right);
      System.out.print(tree[root]+" ");
    }
  }

  public static void main(String[] args) {
    int[] binTree = {13,4,8,24,15,10,3,7,5};
    depthFirstTraversal(binTree, 0);
  }
}