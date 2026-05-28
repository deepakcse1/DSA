package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
  public static void main(String[] args) {
    
  }

  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    helper(root, res, 0);
    return res;
  }

  public void helper(TreeNode root, List<Integer> res, int level) {
    if (root == null) return;
    if (level == res.size()) res.add(root.val);
    helper(root.right, res, level + 1);
    helper(root.left, res, level + 1);
  }
}
