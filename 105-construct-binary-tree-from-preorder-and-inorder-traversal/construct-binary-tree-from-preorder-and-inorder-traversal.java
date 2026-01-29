/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// class Solution {
//     int preorderIndex;
//     Map<Integer, Integer> inorderIndexMap;
//     public TreeNode buildTree(int[] preorder, int[] inorder) {
//         preorderIndex=0;
//         inorderIndexMap=new HashMap<>();
//         for(int i=0; i<inorder.length; i++){
//             inorderIndexMap.put(inorder[i], i);
//         }
//         return arrayToTree(preorder, 0, preorder.length-1);
//     }
//     public TreeNode arrayToTree(int[] preorder, int left, int right){
//         if(left>right){
//             return null;
//         }
//         int rootValue=preorder[preorderIndex++];
//         TreeNode root=new TreeNode(rootValue);
//         int splitIndex=inorderIndexMap.get(rootValue);
//         root.left=arrayToTree(preorder, left, splitIndex-1);
//         root.right=arrayToTree(preorder, splitIndex+1, right);
//         return root;
//     }
// }

class Solution{
    // piyush
    int preorderIndex;
    Map<Integer, Integer> inorderIndexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder){
        preorderIndex=0;
        inorderIndexMap=new HashMap<>();
        for(int i=0; i<=preorder.length-1; i++){
            inorderIndexMap.put(inorder[i], i);
        }
        return arrayToTree(preorder, 0, preorder.length-1);
    }
    public TreeNode arrayToTree(int[] preorder, int left, int right){
        if(left>right){
            return null;
        }
        int rootValue=preorder[preorderIndex++];
        TreeNode root=new TreeNode(rootValue);
        int splitValue=inorderIndexMap.get(rootValue);
        root.left=arrayToTree(preorder, left, splitValue-1);
        root.right=arrayToTree(preorder, splitValue+1, right);
        return root;
    }
}