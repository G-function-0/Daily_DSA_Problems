//LEETCODE solution

/*
Approach O(n) : 
    its pretty simple and straight forward trust me try to see it this way 
        maintain of count of how many hours are on my right where customers are 'Y'
            cause they can cause penatly right 
        and if the current hour have no customer then current hour caused us penalty right cause we opened our shop for nogood 
        and thats it i have implemented this idea in the broader sense 
*/

class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int numN =0,numY =0;
        for(int i =0; i< n;i++){
            if(customers.charAt(i) == 'Y')  numY++;
        }
        int p = numY;
        int j = 0;
        int currP = p;
        for(int i =0;i<n;i++){
            char ch = customers.charAt(i);
            if(ch == 'Y'){
                numY--;
                currP--;
            }
            else{
                numN++;
                currP +=1; //for no customer condition right?
            }
            if(currP < p){
                j=i+1;
                p=currP;
            }
        }
        return j;
    }
}