/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// public class Codec {

    // Encodes a tree to a single string.
    // public String recSerialize(TreeNode root, String str){
    //     if(root==null){
    //         str+="null,";
    //     }
    //     else{
    //         str+=str.valueOf(root.val)+",";
    //         str=recSerialize(root.left, str);
    //         str=recSerialize(root.right, str);
    //     }
    //     return str;
    // }
    // public String serialize(TreeNode root) {
    //     return recSerialize(root, "");
    // }

    // Decodes your encoded data to tree.
//     public TreeNode recDeserialize(List<String> str){
//         if(str.get(0).equals("null")){
//             str.remove(0);
//             return null;
//         }
//         TreeNode root=new TreeNode(Integer.valueOf(str.get(0)));
//         str.remove(0);
//         root.left=recDeserialize(str);
//         root.right=recDeserialize(str);
//         return root;
//     }
//     public TreeNode deserialize(String data) {
//         String[] strArray=data.split(",");
//         List<String> strList=new LinkedList<String>(Arrays.asList(strArray));
//         return recDeserialize(strList);
//     }
// }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

public class Codec{
    public String serialize(TreeNode root){
        StringBuilder sb = new StringBuilder();
        serializeDFS(root, sb);
        return sb.toString();
    }
    void serializeDFS(TreeNode root, StringBuilder sb){
        if(root==null){
            sb.append("N,");
            return;
        }
        sb.append(root.val).append(",");
        serializeDFS(root.left, sb);
        serializeDFS(root.right, sb);
    }

    public TreeNode deserialize(String data){
        String[] arr=data.split(",");
        int[] index=new int[1];
        return deserializeDFS(arr, index);
    }
    public TreeNode deserializeDFS(String[] arr, int [] index){
        if(arr[index[0]].equals("N")){
            index[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(arr[index[0]]));
        index[0]++;
        node.left=deserializeDFS(arr, index);
        node.right=deserializeDFS(arr, index);
        return node;
    }
}