package BinaryTree;

public class SubtreeOfAnotherTree {
  public static void main(String[] args) {
    
  }

  class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
      if (root == null) return false;
      if (helper(root, subRoot)) return true;
      return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean helper(TreeNode root, TreeNode subRoot) {
      if (root == null && subRoot == null) return true;
      if (root == null || subRoot == null || root.val != subRoot.val) return false;
      return helper(root.left, subRoot.left) && helper(root.right, subRoot.right);
    }
  }
}
