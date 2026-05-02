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

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q == null)
            return true;
         if(p==null || q == null)
            return false;

        int val1 = p.val;
        int val2 = q.val;

        if(val1 != val2)
            return false;
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
