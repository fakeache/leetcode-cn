package Simple;

import java.util.Stack;

class Solution {
    public static String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        String previous = countAndSay(n-1);
        StringBuilder sb = new StringBuilder();
        int num=1;
        char c=previous.charAt(0);
        Stack<Character> stack = new Stack<>();
        for(int i=1;i<previous.length();i++){
            char cur = previous.charAt(i);
            if(cur==c){
                num++;
            }
            else{
                stack.clear();
                while(num>0){
                    int temp = num%10;
                    stack.push((char)('0'+temp));
                    num=num/10;
                }
                while(!stack.empty()){
                    sb.append(stack.pop());
                }
                sb.append(c);
                num=1;
                c=cur;
            }
        }
        stack.clear();
        while(num>0){
            int temp = num%10;
            stack.push((char)('0'+temp));
            num=num/10;
        }
        while(!stack.empty()){
            sb.append(stack.pop());
        }
        sb.append(c);
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(countAndSay(4));
        //StringBuilder 可以直接append数值类型，所以上面代码可以简化
        StringBuilder sb1 = new StringBuilder();
        double d = 1.084;
        int x =1;
        boolean sf = true;
        float sff =1.31f;
        sb1.append(d).append(x).append(sf).append(sff);
        System.out.println(sb1.toString());
    }
}