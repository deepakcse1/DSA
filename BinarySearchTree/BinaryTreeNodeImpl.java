import java.util.ArrayList;

class TreeNode<T>{
    T data;
    TreeNode<T> left;
    TreeNode<T> right;
    public TreeNode(T data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
class BSTcarrier{
  int min, max;
  boolean isBST;
  public BSTcarrier(int min, int max, boolean isBST){
    this.min = min;
    this.max = max;
    this.isBST = isBST;
  }
}
public class BinaryTreeNodeImpl {
    public void print(TreeNode<Integer> root){
        if(root == null) return;
        System.out.println(root.data+" ");
        print(root.left);
        print(root.right);
    }

    public boolean searchInBST(TreeNode<Integer> root, int k) {
        if(root == null) return false;
        if(root.data == k) return true;
        if(k < root.data) return searchInBST(root.left, k);
        return searchInBST(root.right, k);
	}

    public void elementsInRangeK1K2(TreeNode<Integer> root,int k1,int k2){
		if(root == null) return;
        if(root.data < k1) elementsInRangeK1K2(root.right, k1, k2);
        else if(root.data > k2) elementsInRangeK1K2(root.left, k1, k2);
        else{
            System.out.println(root.data);
            elementsInRangeK1K2(root.left, k1, k2);
            elementsInRangeK1K2(root.right, k1, k2);
        }
	}

    public int maximum(TreeNode<Integer> root){
        if(root == null) return Integer.MIN_VALUE;
        int leftMax = maximum(root.left);
        int rightMax = maximum(root.right);
        return Math.max(root.data, Math.max(leftMax, rightMax));
    }
    public int minimum(TreeNode<Integer> root){
        if(root == null) return Integer.MAX_VALUE;
        int leftMin = minimum(root.left);
        int rightMin = minimum(root.right);
        return Math.min(root.data, Math.min(leftMin, rightMin));
    }
    public boolean isBST(TreeNode<Integer> root){
       if(root == null) return true;
       int leftMax = maximum(root.left);
       if(leftMax >= root.data) return false;
       int rightMin = minimum(root.right);
       if(rightMin < root.data) return false;
       boolean isLeftBST = isBST(root.left);
       boolean isRightBST = isBST(root.right);
       return isLeftBST && isRightBST;
    }

    public BSTcarrier isBSTBetter(TreeNode<Integer> root){
       if(root == null){
         BSTcarrier ans = new BSTcarrier(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
         return ans;
       }
       BSTcarrier leftAns = isBSTBetter(root.left);
       BSTcarrier rightAns = isBSTBetter(root.right);
       int min = Math.min(root.data, Math.min(leftAns.min, rightAns.min));
       int max = Math.max(root.data, Math.max(leftAns.max, rightAns.max));
       boolean isBST = true;
       if(leftAns.max >= root.data || rightAns.min < root.data || !leftAns.isBST || !rightAns.isBST) isBST = false;
       BSTcarrier ans = new BSTcarrier(min, max, isBST);
       return ans;
    }

    public boolean isBSTBest(TreeNode<Integer> root, int minRange, int maxRange){
        if(root == null) return true;
        if(root.data < minRange || root.data > maxRange) return false;
        boolean isLeftWithinRange = isBSTBest(root.left, minRange, root.data -1);
        boolean isRighttWithinRange = isBSTBest(root.right, root.data, maxRange);
        return isLeftWithinRange && isRighttWithinRange;
    }

    public ArrayList<Integer> nodeToRoot(TreeNode<Integer> root, int data) {
        if (root == null)
            return null;
        if (root.data == data) {
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(root.data);
            return ans;
        }
        ArrayList<Integer> leftOutput = nodeToRoot(root.left, data);
        if (leftOutput != null) {
            leftOutput.add(root.data);
            return leftOutput;
        }
        ArrayList<Integer> rightOutput = nodeToRoot(root.right, data);
        if (rightOutput != null) {
            rightOutput.add(root.data);
            return rightOutput;
        }
        return null;
    }

    public TreeNode<Integer> sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start) / 2;  // Prevents overflow
        TreeNode<Integer> node = new TreeNode<Integer>(nums[mid]);

        node.left = sortedArrayToBST(nums, start, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, end);

        return node;
    }


    // public TreeNode<Integer> insert(TreeNode<Integer> node, int x){
    //    if(node == null){
    //     TreeNode<Integer> newNode = new TreeNode<Integer>(x);
    //     return newNode;
    //    }
    //    if(x >= node.data){
    //     node.right =  insert(node.right, x);
    //    }else{
    //     node.left =  insert(node.left, x);
    //    }
    //    return node;
    // }
   
}


