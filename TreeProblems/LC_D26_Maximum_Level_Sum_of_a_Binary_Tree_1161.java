//LEETCODE solution 

/*
Approach O(q.size()+ log(n)) : 
        SIMPLE do Level Order Traversal in this tree and find sum of each level
            and store level with maximum sum
        L
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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        int ans =0; 
        long sum = 0; 
        long maxSum = Long.MIN_VALUE;
        int level = 1;
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            
            if(curr == null){
                q.offer(null);
                if(q.peek()==null){
                    break;
                }
                if(maxSum < sum){
                    maxSum = sum;
                    ans = level;
                }
                sum=0;
                level++;
                continue;
            }

            sum += curr.val;
            if(curr.left != null)
                q.offer(curr.left);
            if(curr.right != null){ 
                q.offer(curr.right);
            }
        }
        if(maxSum < sum){
                    maxSum = sum;
                    ans = level;
                }

        return ans;
    }
}