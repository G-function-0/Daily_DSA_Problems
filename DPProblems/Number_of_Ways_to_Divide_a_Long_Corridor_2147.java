//LeetCode Solution 
/*
Approach O(n):
    so i havent done dp approach yet but yeah lets see this one :
    first i have scaned through the string and figuredout how many seats are thier in total 
    if the numbers are odd then simply return 0
    no take to vars tracking left seats and right seats 
    now simply traverse trough the string and as we get 2 seates our section is complete 
        now we need to find total gaps to place that DIVIDER 
        simple find that gaps and multiply to the current permutation 
            WHY multiply ?  ok so let me answer that its a concept of PandC 
                i had learned that when our work is not compleate then we should multiply 
                    our work here is to divide the whole section not only the section right?
                        so thats that when we find total ways to divide to sections we multiply 
            IF its hard to digest let me tell you how i reached to this conclusion 
                its simple dry run fe examples you will find that pattern 
 */

class Solution {
    public int numberOfWays(String corridor) {
        int countS = 0;
        final int MOD = 1000000007;
        for(int i=0;i<corridor.length();i++){
            if(corridor.charAt(i) == 'S'){
                countS++;
            }
        }
        int leftS = 0;
        int rightS = countS;
        if(countS%2!=0 || countS == 0){
            return 0;
        }

        // System.out.println(countS);
        long ans =1;
        int subPermute = 0;
        for(int i=0;i<corridor.length();i++){
            char curr = corridor.charAt(i);
            if(curr == 'S')
            {
                leftS++;
                rightS--;
            }
            if(leftS == 2){
                subPermute++;
            }
            if(leftS==3){
                leftS=1;
                ans = (ans * (subPermute%MOD))%MOD;
                subPermute = 0;
                //just for optimization;we can workout it also 
                if(rightS==1){
                    break;
                }
            }
        }
        return (int)ans;
    }
}