//LEETCODE solution 
/*
Approach O(n2): 
    it is quit simple to think 
        First filter out all the arrays on the basis of isActive then on businessLine and then on code restrictions
        now we need to Sort the new array i have created first on the basis of businessLine and then if business is same then on the basis of code lexicographical 
    

Learnings from this problem : (I in this problem i have done some non generic stuff because i experimenting with the problem)
    like lexicographical order of businessLine was just a coincidence i shoud havve use map with enumerations for all four businessLines that would be scalable 
        ex : Map<String, Integer> hm = new Map<>();
        hm.put("electronics" , 1);
        hm.put("grocery" , 2); and so on...

    What is learned : 
        -How 2D list works 
            want to add a row in the 2d list -> List.add(List.of(code,businessLine));
                remeber List.of creates an immutable List so we should not use it unless 
                    we should use Arrays.asList(code,businessLine);
            want to access each value of 2d list column wise then 
                use get().get() 
                    list.get(0).get(1);
                    this ill spit 0,1 value;
*/
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        int n = code.length;
        List<List<String>> ans = new ArrayList<>();;
        List<String> allowed = List.of("electronics", "grocery", "pharmacy", "restaurant");
        for(int i =0;i<n;i++){
            if(!isActive[i]){
                businessLine[i] ="";
                code[i] = "";
            }
        }
        for(int i =0;i<n;i++){
            //for code array 
            String curr = code[i];
            for(int j = 0;j<curr.length();j++){
                char c = curr.charAt(j);
                if(!((c>='a' && c<='z') || (c>='A' && c<='Z') || c=='_' || (c<='9' && c>='0'))){
                    curr = "";
                    businessLine[i]="";
                    isActive[i] = false;
                }
            }
            code[i] = curr;
        }

        for(int i = 0;i<n;i++){
            String curr = businessLine[i];
            if(!allowed.contains(curr)){
                code[i] = "";
                businessLine[i] = "";
                isActive[i] = false;
                continue;
            }
            if(!code[i].equals(""))
                ans.add(List.of(code[i],businessLine[i]));
        }
        ans.sort((o1,o2)->{
            String b1 = o1.get(1);
            String b2 = o2.get(1);
            if(b1.compareTo(b2) != 0)
                return b1.compareTo(b2);
            b1 = o1.get(0);
            b2 = o2.get(0);
            return b1.compareTo(b2);
        });
        List<String> codes = new ArrayList<>();
        for(int i =0;i<ans.size();i++){
            codes.add(ans.get(i).get(0));
        }
        return codes;
    }
}