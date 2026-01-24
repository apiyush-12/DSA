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
//     int maxDia=0;
//     public int diameterOfBinaryTree(TreeNode root) {
//         getH(root);
//         return maxDia;
//     }
//     public int getH(TreeNode node){
//         if(node==null){
//             return 0;
//         }
//         int leftH=getH(node.left);
//         int rightH=getH(node.right);

//         maxDia=Math.max(maxDia, leftH+rightH);
//         return 1+Math.max(leftH, rightH);
//     }
// }

class Solution{
    int maxDia=0;
    public int diameterOfBinaryTree(TreeNode root){
        getHeight(root);
        return maxDia;
    }
    public int getHeight(TreeNode node){
        if(node==null){
            return 0;
        }
        int leftH=getHeight(node.left);
        int rightH=getHeight(node.right);
        maxDia=Math.max(leftH+rightH, maxDia);
        return 1+Math.max(leftH, rightH);
    }
}