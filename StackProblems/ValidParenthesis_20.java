//Leetcode solution 

// approach : stacking 
//     simple it seasy 
//         think like this every opening bracket must be closed to be balanced write 
//             so when you encounter opening bracket you push it in the stack 
//             and when you encounter closing bracket you pop the top of the stack 
//                     and IF IF their is no opening bracket that is stack is empty the condition is voilated right ?
            
//                 Next Few Edge cases here 1st is brackets are of different types so thier is need of proper pairing simple 

//                 other thing can be that string is over but their are few opening brackets left in the stack that is they were not closed so VOILATION 
//                 thats it 
//                 i think these are the only edge case for now in my mind 
                


class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> para = new Stack<>();
        for(int i = 0;i < n;i++){
            char ch = s.charAt(i);

            if(ch=='{' || ch =='[' || ch == '('){
                para.push(ch);
            }
            else{
                if(para.isEmpty()){
                    return false;
                }
                char top = para.pop();
                if ((ch == ')' && top == '(') ||
                    (ch == ']' && top == '[') ||
                    (ch == '}' && top == '{')){

                    }
                    else{
                        return false;
                    }
            }
        }
        if(para.isEmpty())
            return true;
        return false;
    }
}