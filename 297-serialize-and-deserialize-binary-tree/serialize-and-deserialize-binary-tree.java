/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String recSerialize(TreeNode root, String str){
        if(root==null){
            str+="null,";
        }
        else{
            str+=str.valueOf(root.val)+",";
            str=recSerialize(root.left, str);
            str=recSerialize(root.right, str);
        }
        return str;
    }
    public String serialize(TreeNode root) {
        return recSerialize(root, "");
    }

    // Decodes your encoded data to tree.
    public TreeNode recDeserialize(List<String> str){
        if(str.get(0).equals("null")){
            str.remove(0);
            return null;
        }
        TreeNode root=new TreeNode(Integer.valueOf(str.get(0)));
        str.remove(0);
        root.left=recDeserialize(str);
        root.right=recDeserialize(str);
        return root;
    }
    public TreeNode deserialize(String data) {
        String[] strArray=data.split(",");
        List<String> strList=new LinkedList<String>(Arrays.asList(strArray));
        return recDeserialize(strList);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));