public class KthSmallestElement {
  int count = 0;
  TreeNode res = null;

  public static void main(String[] args) {

  }

  public int kthSmallest(TreeNode root, int k) {
    helper(root, k);
    return res.val;
  }

  public void helper(TreeNode root, int k) {
    if (root == null) return;
    helper(root.left, k);
    count++;
    if (count == k) {
      res = root;
      return;
    }
    helper(root.right, k);
  }
}
