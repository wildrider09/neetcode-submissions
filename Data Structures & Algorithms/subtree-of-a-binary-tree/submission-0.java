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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        boolean flag = false;

        if(root==null && subRoot==null)
            return true;
        if(root==null || subRoot==null)
            return false;

        if(subRoot.val == root.val){
            if(checkSame(root, subRoot))
                return true;
        }
        flag = isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

        return flag;
    }

    boolean checkSame(TreeNode root, TreeNode subRoot){
        if(root==null && subRoot==null)
            return true;
        if(root==null || subRoot==null)
            return false;

        if(root.val == subRoot.val)
            return checkSame(root.left, subRoot.left) && checkSame(root.right, subRoot.right);
        else 
            return false;
    }
}
