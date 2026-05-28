package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
  public static void main(String[] args) {
    
  }

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    helper(root, 0, res);
    return res;
  }

  public void helper(TreeNode root, int level, List<List<Integer>> res) {
    if (root == null) return;
    if (level == res.size()) {
      res.add(new ArrayList<>());
    }
    res.get(level).add(root.val);
    helper(root.left, level + 1, res);
    helper(root.right, level + 1, res);
  }
}
