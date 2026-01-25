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
//     public boolean isBalanced(TreeNode root) {
//         if(root==null){
//             return true;
//         }
//         int leftH=getH(root.left);
//         int rightH=getH(root.right);
//         if(Math.abs(leftH-rightH)>1){
//             return false;
//         }
//         return isBalanced(root.left) && isBalanced(root.right);
//     }
//     private int getH(TreeNode node){
//         if(node==null){
//             return 0;
//         }
//         int left=getH(node.left);
//         int right=getH(node.right);
//         return Math.max(left, right)+1;
//     }
// }

// piyush
// class Solution{
//     public boolean isBalanced(TreeNode root){
//         if(root==null){
//             return true;
//         }
//         int leftH=getH(root.left);
//         int rightH=getH(root.right);
//         if(Math.abs(leftH-rightH)>1){
//             return false;
//         }
//         return isBalanced(root.left) && isBalanced(root.right);
//     }
//     private int getH(TreeNode node){
//         if(node==null){
//             return 0;
//         }
//         int left=getH(node.left);
//         int right=getH(node.right);
//         return Math.max(left, right) +1;
//     }
// }

// piyush
class Solution{
    boolean balanceFactor=true;
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int lH=height(root.left);
        int rH=height(root.right);
        if(Math.abs(lH-rH)>1){
            balanceFactor=false;
        }
        return Math.max(lH, rH)+1;
    }
    public boolean isBalanced(TreeNode root){
        int h=height(root);
        return balanceFactor;
    }
}