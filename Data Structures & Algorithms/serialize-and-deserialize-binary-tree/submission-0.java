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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "N";
        
        Queue<TreeNode> queue = new LinkedList<>();
        String s = "";
        queue.add(root);

        while(!queue.isEmpty()){
            int count = queue.size();
            for(int i = 0; i<count ; i++){
                TreeNode temp = queue.poll();
                if(temp == null){
                    s = s + "N,";
                    continue;
                }
               
                s = s + temp.val + ",";
                queue.add(temp.left);
                queue.add(temp.right);
            }
        }
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String vals[] = data.split(",");
        if(vals[0].equals("N"))
            return null;

        int index = 0;
        TreeNode root = new TreeNode(Integer.parseInt(vals[index++]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(!vals[index].equals("N")){
                temp.left = new TreeNode(Integer.parseInt(vals[index]));
                queue.add(temp.left);
            }
            index ++;
            if(!vals[index].equals("N")){
                temp.right = new TreeNode(Integer.parseInt(vals[index]));
                queue.add(temp.right);
            }
            index ++;
        }

        return root;        
    }
}
