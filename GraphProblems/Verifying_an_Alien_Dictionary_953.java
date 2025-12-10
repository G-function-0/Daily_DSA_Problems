// LEETCODE solution
import java.util.HashMap;

/*
Approach O(n2) : Using HashMap/Array 
    easy enumerate the order using HashMap
    now check for order or words letters and some edge cases as in code Simple 
*/
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0;i<order.length();i++){
            hm.put(order.charAt(i),i);
        }
        String prev = words[0];
        if(words.length == 1){
            return true;
        }
        for(int i=1;i<words.length;i++){
            String curr = words[i];
            int j =0;
            for(;j<Math.min(curr.length(),prev.length());j++){
                if(hm.get(curr.charAt(j))<hm.get(prev.charAt(j))){
                    return false;
                }
                else if(hm.get(curr.charAt(j))>hm.get(prev.charAt(j))){
                    break;
                }
            }
            if(j==curr.length() && curr.length()<prev.length()){
                return false;
            }
            prev = curr;
        }
        return true;
    }
}
