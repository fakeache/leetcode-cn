package Simple;

import java.util.Stack;

class Solution20 {
    static Stack<Character> stack = new Stack<Character>();
    public static boolean isValid(String s) {
        if(s==null){
            return true;
        }
        else{
            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);
                if(c=='(' || c=='{' || c=='['){
                    stack.push(c);
                }
                else{
                    if(stack.empty()){
                        return false;
                    }
                    else{
                        char top = stack.peek();
                        if(top=='('&&c==')'){
                            stack.pop();
                        }
                        else if(top=='{'&&c=='}'){
                            stack.pop();
                        }
                        else if(top=='['&&c==']'){
                            stack.pop();
                        }
                        else{
                            return false;
                        }
                    }
                }
            }
            if(stack.empty()){
                return true;
            }
            else{
                return false;
            }
        }
    }

    public static void main(String[] args){
        System.out.println(isValid("()"));
    }
}
