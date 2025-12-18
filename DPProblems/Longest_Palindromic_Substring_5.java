//LEETCODE solution
/*
    Approach O(n2) Two pointer approach :
        simple we check palindrome starting from the center of the string and if bother left and right side of the string looks symetrical then its a palindrom 
        thats what we will do -> 
            we will go to every i and consider it the center of the palindrome and check for its left and right if same 
                then we increase the count and at last check for the maximum 

        Edge : case of even palindromic substring is the edge case 
            for that we can just consider 2 elements as the center of the palindrome and do the same thing again 

        How we can convert this in 1D dp :
            just d[i]  = max len of substring that is also an palindrome and at every state we can update the answer to retrun by comparing it to the dp[i] 
            JUST A THOUGHT not sure if this how e should do it havent given it a thought YET!

*/ 



class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int subLen =0;
        String sub ="";
        for(int i =0;i<n;i++){
            int l1 = 1;
            String temp1 =String.valueOf(s.charAt(i));
            
            int l2 = 0;
            String temp2 ="";

            for(int j =i-1,k=i+1;j>=0 && k<n;j--,k++){
                if(s.charAt(j) == s.charAt(k)){
                    l1 +=2;
                    temp1 = String.valueOf(s.charAt(j))+temp1+String.valueOf(s.charAt(k));
                }
                else{
                    break;
                }
                

            }
            for(int j = i,k=i+1;j>=0 && k<n;j--,k++){
                if(s.charAt(j) == s.charAt(k)){
                    l2 +=2;
                    temp2 = String.valueOf(s.charAt(j))+temp2+String.valueOf(s.charAt(k));
                }
                else{
                    break;
                }
            }
            if(subLen<Math.max(l1,l2)){
                subLen= Math.max(l1,l2);
                sub = (l1==subLen)?temp1:temp2;
            }

        }

        return sub;
    }
}
