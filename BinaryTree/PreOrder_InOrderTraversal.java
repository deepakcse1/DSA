package BinaryTree;


import java.util.HashMap;
import java.util.Map;


public class PreOrder_InOrderTraversal {
  int preOrderIndex = 0;
  Map<Integer, Integer> map = new HashMap<>();

  public static void main(String[] args) {

  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    for (int i = 0; i < preorder.length; i++) {
      map.put(inorder[i], i);
    }
    return helper(preorder, inorder, 0, preorder.length - 1);
  }

  public TreeNode helper(int[] preorder, int[] inorder, int left, int right) {
    if (left > right) return null;
    TreeNode root = new TreeNode(preorder[preOrderIndex++]);
    // int inOrderRootIndex = search(inorder, root.val, left, right);
    int inOrderRootIndex = map.get(root.val);
    root.left = helper(preorder, inorder, left, inOrderRootIndex - 1);
    root.right = helper(preorder, inorder, inOrderRootIndex + 1, right);
    return root;
  }
}
