public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }
    public void serializeHelper(TreeNode root, StringBuilder sb){
        if(root == null) return;
        sb.append(root.val).append(",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    int index;
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        String arr[] = data.split(",");
        index = 0;
        return deserializeHelper(arr, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode deserializeHelper(String arr[], int min, int max){
        if(index == arr.length) return null;
        int val = Integer.parseInt(arr[index]);
        if(val < min || val > max) return null;
        index++;
        TreeNode root = new TreeNode(val);
        root.left = deserializeHelper(arr, min, val);
        root.right = deserializeHelper(arr, val, max);
        return root;
    }
}