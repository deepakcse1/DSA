package BinaryTree;

public class DiameterOfBinaryTree {
  int dia = 0;
  public static void main(String[] args) {
    
  }

  public int diameterOfBinaryTree(TreeNode root) {
    helper(root);
    return dia;
  }

  public int helper(TreeNode root) {
    if (root == null) return 0;
    int leftC = helper(root.left);
    int rightC = helper(root.right);
    dia = Math.max(dia, leftC + rightC);
    return 1 + Math.max(leftC, rightC);
  }
}
