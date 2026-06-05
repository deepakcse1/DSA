package BinaryTree;

public class BalanceBinaryTree {
  public static void main(String[] args) {

  }

  public boolean isBalanced(TreeNode root) {
    return height(root) != -1;
  }

  public int height(TreeNode root) {
    if (root == null) return 0;
    int leftH = height(root.left);
    int rightH = height(root.right);
    if (leftH == -1 || rightH == -1) return -1;
    if (Math.abs(leftH - rightH) > 1) return -1;
    return 1 + Math.max(leftH, rightH);
  }
}
