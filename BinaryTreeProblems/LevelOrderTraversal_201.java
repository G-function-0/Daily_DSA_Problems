//LEETCODE solution : https://leetcode.com/problems/binary-tree-level-order-traversal
/*
Approach :
    its not that hard when ever you see level order traversal you use queue
    in my method is add each nodes left and right node and i use null as indicator that this is end for this level we need to add this list in our ans list and move on with next 


    it can be done with out this null pointer also by useing current size of the queue but thats for another day 
    
*/

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root == null){
            return ans;
        }
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            q.offer(null);
            TreeNode curr = q.poll();
            List<Integer> l = new ArrayList<>(); 
            while(curr != null){
                if(curr.left!=null){
                    q.offer(curr.left);
                }
                if(curr.right != null){
                    q.offer(curr.right);
                }
                l.add(curr.val);
                curr = q.poll();
            }
            ans.add(l);
        }
        return ans;
    }
}