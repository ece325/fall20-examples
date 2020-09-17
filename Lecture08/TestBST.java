public class TestBST
{
  public static void main(String[] args) {
    int[] data = {9,3,15,10,1,5,18,6,12};
    // int[] data = {1,3,5,6,9,10,12,15,18};

    BinarySearchTree bst = new BinarySearchTree();

    for (int v : data) {
      bst.insert(v);
    }
    bst.printTree();
  }
}

