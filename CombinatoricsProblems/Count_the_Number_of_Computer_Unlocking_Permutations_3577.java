// LEETCODE solution

/*
Approach O(n) : Used Hint for this question 
                Ensure that the element at index 0 has the unique minimum complexity (no other element can match its value).
                    you can dry run and see why if their exist any ele less than index[0] then solution will lead to 0
                
                if this is not the case then 
                    permutation = factorial(n-1) simple dry run and you will get it 
                    */


class Solution {
    public int countPermutations(int[] complexity) {
        boolean check = true;
        int n = complexity.length;
        long permutations = 1;
        final int MOD = 1000000007;

        for(int i = 1;i < n; i++){
            if(complexity[i]<= complexity[0]){
                check = false;
            }
            permutations = (permutations * i) % MOD;
        }
        if(!check){
            return 0;
        }

        return (int)permutations;
    }
}