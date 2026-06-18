package BinaryTree;

public class MinimumDepthOfBinaryTree {
  public int minDepth(TreeNode root) {
    if(root == null) return 0;
      return helper(root);
    }
    public int helper(TreeNode root) {
      if(root == null) return Integer.MAX_VALUE;
      int left = helper(root.left);
      int right = helper(root.right);
      if(left == Integer.MAX_VALUE && right == Integer.MAX_VALUE) return 1;
      return 1 + Math.min(left, right);
    }
}
