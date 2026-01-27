/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         int parentVal=root.val;
//         int pVal=p.val;
//         int qVal=q.val;
//         if(pVal>parentVal && qVal>parentVal){
//            return lowestCommonAncestor(root.right, p, q);
//         }
//         else if(pVal<parentVal && qVal<parentVal){
//             return lowestCommonAncestor(root.left, p, q);
//         }
//         else{
//             return root;
//         }
//     }
// }


// piyush
class Solution{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return null;
        }
        while(root!=null){
            if(root.val>p.val && root.val>q.val){
                root=root.left;
            }else if(root.val<p.val && root.val<q.val){
                root=root.right;
            }else{
                break;
            }
        }
        return root;
    }
}

// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         while (root != null) {
//             if (p.val > root.val && q.val > root.val) {
//                 root = root.right;
//             } else if (p.val < root.val && q.val < root.val) {
//                 root = root.left;
//             } else {
//                 return root;
//             }
//         }
//         return null;
//     }
// }