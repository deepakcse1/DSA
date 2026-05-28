package BinaryTree;

public class SameTree {
  public static void main(String[] args) {
    
  }

  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (p == null || q == null || p.val != q.val) return false;
    boolean isLeftSame = isSameTree(p.left, q.left);
    boolean isRightSame = isSameTree(p.right, q.right);
    return isLeftSame && isRightSame;
  }
}
