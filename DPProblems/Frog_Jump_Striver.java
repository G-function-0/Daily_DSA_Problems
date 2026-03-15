//CODING NINJA STUDIOS 360
//   https://www.naukri.com/code360/problems/frog-jump_3621012 
//Approach : will discuss later


import java.util.* ;
import java.io.*; 
public class Solution {
    public static int frogJump(int n, int heights[]) {

        // Write your code here..
        if(n==1){
            return 0;
        }
        if(n==2){
            return heights[1]-heights[0];
        }

        int prev = Math.abs(heights[1] - heights[0]);
        int beforePrev = 0;

        for(int i = 2;i<n;i++){
            int curr = (Math.abs(heights[i]-heights[i-1])+prev);
            int min = Math.min(curr,(beforePrev+Math.abs(heights[i]-heights[i-2])));
            beforePrev = prev; 
            prev = min;
        }
        return prev;
    }

}