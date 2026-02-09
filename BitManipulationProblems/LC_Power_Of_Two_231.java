//LEETCODE solution 
/*
Approach (YO!) : 
    this is a concept we are tought in BItManipulation and it is Littrelly used everywhere so remmeber this 

    for a number a to be power of 2 
        n & n-1 == 0 THIS CONDITION MUST HOLD TRUE 

        WHY ? good question 
            bause in all the numbers which are power of 2 it contains only 1 set bit
            1  = 0001
            2  = 0010
            4  = 0100
            8  = 1000 
            and as we do -1 from that num all the un-set bits flip along with the set bit becoming 0 

            and thus when we & both n and n-1 it gives zero 

            8 = 1000
            7 = 0111
            8 & 7 = 0000

            
*/

class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0){
            return false;
        }
        return ((n&(n-1))==0);
    }
}