//LEETCODE solution 
/*
    Approach O(n2): 
        this problem is vvery similar to Longest Palindromic Substring Problem 5
        just we need to add all the substrigns we are getting palindromes 
        simple same approach see that question 
*/


class Solution {
    public static int countPal(int s1, int s2, String s){
        int i = s1,j=s2;
        int n = s.length();
        int c = 0;
        while(i>=0 && j<s.length() && (s.charAt(i) == s.charAt(j))){
            c++;
            i--;
            j++;
        }
        return c;
    }
    public int countSubstrings(String s) {
        int ans = 0;
        for(int i =0;i<s.length();i++){
            int ans1 = countPal(i,i+1,s);//evenPals
            int ans2 = countPal(i,i,s);//oddPals
            ans += ans1+ans2;

        }
        return ans;
    }
}
