//LEETCODE solution
/*
Approach O(n+nlog(n)) : 
    simple Sort th4e array and take the first k happiness simple as that 

*/




class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long ans =0;
        int i =1;
        int n = happiness.length;
        while(i != k+1){
            int happy = happiness[n-i]-i+1;
            ans += (happy > 0)? happy : 0;
            i++;
        }
        return ans;
    }
}




//Priority Queue  solution O(n+klog(k));

// class Solution {
//     public long maximumHappinessSum(int[] happiness, int k) {
//         PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
//         long ans =0;
//         for(int h : happiness){
//             pq.add(h);
//         }
//         int i =1;

//         while(i != k+1){
//             int happy = pq.poll()-i+1;
//             ans += (happy > 0)? happy : 0;
//             i++;
//         }
//         return ans;
//     }
// }