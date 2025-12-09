// LEETCODE solution

/*
    Approach O(N^2) : 
        just simple traverse on j as index 
        and check in 2nd and 3rd sibling loop that if their exists any nums that is equle to num[j]*2 
        and add (countRight*countLeft) to the count and do the MOD thing 
    Approach O(n) : we need to mainting a freqPrev And freqNext array or HashMap 
        (array is better if it in the constrains bound i will tell why) 
        now for this count the freq of each number and keep it 
        now as we traverse from 0 to n-1 we do 
        reduce the freq of current element and 
        add current ele to freqPrev so that e can track it as previous now 
        do the same check and MOD thing like last Approach

    Why array is better than HashMap? (Just some CP Stuff)
        just understand their is some time taken during creating for each key-value pair in map 
        that time makes HashMaps 3-5 times slower than Arrays 
        So if the constraines allowe always prefer ARRAY over HashMap
 */
class Solution {

    public int specialTriplets(int[] nums) {
        final int MOD = 1_000_000_007;
        HashMap<Integer, Integer> freqPrev = new HashMap<>();
        HashMap<Integer, Integer> freqNext = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            freqNext.put(nums[i], freqNext.getOrDefault(nums[i], 0) + 1);
        }
        long count = 0;
        for (int j = 0; j < n - 1; j++) {
            freqNext.put(nums[j], freqNext.get(nums[j]) - 1);
            long next = freqNext.getOrDefault(nums[j] * 2, 0);
            long prev = freqPrev.getOrDefault(nums[j] * 2, 0);
            // long mul = (next*prev);
            count = (count + ((next % MOD) * (prev % MOD))) % MOD;
            freqPrev.put(nums[j], freqPrev.getOrDefault(nums[j], 0) + 1);
        }
        return (int) count % MOD;
    }
}
