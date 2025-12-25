//LEETCode Solution 
/*
Approach O(n+nlog(n)) : 
    simple sort the capacity array and fill the boxes util your pack of apples empties out
*/

class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int sum = 0;
        for(int i =0;i< apple.length;i++){
            sum += apple[i];
        }
        int c =0;
        for(int i =0;i<capacity.length;i++){
            if(sum<=0){
                break;
            }
            sum -= capacity[capacity.length-1-i];
            c++;
        }

        return c;
    }
}