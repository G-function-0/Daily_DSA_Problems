//LEETCODE solution 
/*
Approach O(N) : 
    we need a monotonic stack 
        Scary Name 
            nah its simple trust me 
                monotonic static is nothing but a stack which stroes numbers in a particular order (i.e. increasing / decreasing order);
            So Monotonic stack is nothing to be freared of 
    next is we never particularly build monotonic stack so freget this nam e

    Now, finding the next greater element for all numbers in num2
        READ the code for no i am sick these days 
    
*/


class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap <Integer,Integer> hm = new HashMap<>();
        Stack<Integer> s = new Stack<>();
        int n = nums2.length;
        for(int i =n-1;i>-1;i--){
            int max =-1;
            int curr = nums2[i];
            while(!s.isEmpty()){
                if(s.peek() > curr){
                    max = s.peek();
                    break;
                }
                s.pop();
            }
            
            
            s.push(curr);
            
            hm.put(nums2[i],max);
        }


        for(int i =0;i< nums1.length;i++){
            int curr = nums1[i];
            nums1[i] = hm.get(nums1[i]);

        }
        return nums1;
    }
}