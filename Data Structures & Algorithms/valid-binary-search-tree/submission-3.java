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
    int left = Integer.MIN_VALUE, right = Integer.MAX_VALUE;
    public boolean isValidBST(TreeNode root) {

        return isValid(root, left, right);

    }
    boolean isValid(TreeNode root, int left, int right){
        if(root == null)
            return true;
        
        if(root.val <= left || root.val >= right)
            return false;
        
        
        return isValid(root.left, left, root.val) &&
               isValid(root.right, root.val, right);
        
    }
}
