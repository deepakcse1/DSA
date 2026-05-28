package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
  public static void main(String[] args) {

  }

  // Recursive solution
  public boolean isSymmetric_Recursive(TreeNode root) {
    return helper(root.left, root.right);
  }

  public boolean helper(TreeNode node1, TreeNode node2) {
    if (node1 == null && node2 == null) return true;
    if (node1 == null || node2 == null) return false;
    if (node1.val != node2.val) return false;
    boolean farSide = helper(node1.left, node2.right);
    boolean closeSide = helper(node1.right, node2.left);
    return farSide && closeSide;
  }

  // Iterative solution
  public boolean isSymmetric_Iterative(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root.left);
    q.offer(root.right);
    while (!q.isEmpty()) {
      TreeNode node1 = q.poll();
      TreeNode node2 = q.poll();
      if (node1 == null && node2 == null) continue;
      if (node1 == null || node2 == null) return false;
      if (node1.val != node2.val) return false;
      q.offer(node1.left);
      q.offer(node2.right);
      q.offer(node1.right);
      q.offer(node2.left);
    }
    return true;
  }
}
