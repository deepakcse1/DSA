public class BinaryTreeNodeMain {
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(4);
        TreeNode<Integer> node1 = new TreeNode<>(2);
        TreeNode<Integer> node2 = new TreeNode<>(6);
        root.left = node1;
        root.right = node2;
        TreeNode<Integer> node3 = new TreeNode<>(1);
        TreeNode<Integer> node4 = new TreeNode<>(3);
        node1.left = node3;
        node1.right = node4;
        TreeNode<Integer> node5 = new TreeNode<>(5);
        TreeNode<Integer> node6 = new TreeNode<>(7);
        node2.left = node5;
        node2.right = node6;

        BinaryTreeNodeImpl treeImpl = new BinaryTreeNodeImpl();
        // treeImpl.print(root);
        System.out.println(treeImpl.searchInBST(root, 10));
    }

}
