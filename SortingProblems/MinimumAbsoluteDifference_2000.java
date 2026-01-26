//lEETCODE solution 

/*
Approach O(n+nlogn) : 
    simoe sort the array find the minimum abs difference and then do a sliding in windows search in that sorted array for the pairs having abs diff same as  MIN 
    that it 
    
*/


class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for(int i = 0;i<n-1;i++){
            int diff = Math.abs(arr[i]-arr[i+1]);
            if(diff < min){
                min = diff;
            }
        }   
        List<List<Integer>> ans = new ArrayList<>();
        for(int i =0;i<n-1;i++){
            int diff = Math.abs(arr[i]-arr[i+1]);
            if(diff == min){
                List<Integer> l = new ArrayList<>();
                l.add(arr[i]);
                l.add(arr[i+1]);
                ans.add(l);
            }
        }

        return ans;
    }
}