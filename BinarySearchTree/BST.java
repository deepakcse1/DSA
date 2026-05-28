public class BST {
   private TreeNode<Integer> root;
   private static int size;

   private static boolean isPresentHelper(TreeNode<Integer> node, int x) {
      if (node == null)
         return false;
      if (node.data == x)
         return true;
      if (x < node.data) {
         return isPresentHelper(node.left, x);
      } else {
         return isPresentHelper(node.right, x);
      }
   }

   // Time Complexity is Height of the Tree
   public boolean isPresent(int x) {
      return isPresentHelper(root, x);
   }

   private static TreeNode<Integer> insertHelper(TreeNode<Integer> node, int x) {
      if (node == null) {
         TreeNode<Integer> newNode = new TreeNode<Integer>(x);
         size++;
         return newNode;
      }
      if (x >= node.data) {
         node.right = insertHelper(node.right, x);
      } else {
         node.left = insertHelper(node.left, x);
      }
      return node;
   }

   // Time Complexity is Height of the Tree
   public void insert(int x) {
      root = insertHelper(root, x);
   }

   private static void printTreeHelper(TreeNode<Integer> node) {
      if (node == null) return;
      System.out.print(node.data + " :");
      if (node.left != null)
         System.out.print("L " + node.left.data + ", ");
      if (node.right != null)
         System.out.print("R " + node.right.data + ": ");
      System.out.println();
      printTreeHelper(node.left);
      printTreeHelper(node.right);
   }

   public void printTree() {
      printTreeHelper(root);
   }

   public int size() {
      return size;
   }

   private DeleteObject deleteDataHelper(TreeNode<Integer> root, int x) {
      if (root == null) {
         return new DeleteObject(null, false);
      }
      if (root.data < x) {
         DeleteObject rightOutput = deleteDataHelper(root.right, x);
         root.right = rightOutput.newRoot;
         rightOutput.newRoot = root;
         return rightOutput;
      }
      if (root.data > x) {
         DeleteObject leftOutput = deleteDataHelper(root.left, x);
         root.left = leftOutput.newRoot;
         leftOutput.newRoot = root;
         return leftOutput;
      }
      if (root.left == null && root.right == null) {
         return new DeleteObject(null, true);
      }
      if (root.left == null && root.right != null) {
         return new DeleteObject(root.right, true);
      }
      if (root.right == null && root.left != null) {
         return new DeleteObject(root.left, true);
      }
      
      BinaryTreeNodeImpl min = new BinaryTreeNodeImpl();
      int rightMin = min.minimum(root.right);
      root.data = rightMin;
                                          // want to delete rightMin
      DeleteObject newRight = deleteDataHelper(root.right, rightMin);
      root.right = newRight.newRoot;
      return new DeleteObject(root, true);

   }

   // Time Complexity is Height of the Tree
   public boolean deleteData(int x) {
      DeleteObject ans = deleteDataHelper(root, x);
      root = ans.newRoot;
      if (ans.isDeleted)
         size--;
      return ans.isDeleted;
   }
}

class DeleteObject {
   TreeNode<Integer> newRoot;
   boolean isDeleted;

   public DeleteObject(TreeNode<Integer> newRoot, boolean isDeleted) {
      this.newRoot = newRoot;
      this.isDeleted = isDeleted;
   }
}
