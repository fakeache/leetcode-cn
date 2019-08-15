package Simple;

public class Solution171 {
    public static int titleToNumber(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        int sum=0;
        int len = s.length();
        for(int i=0;i<s.length();i++){
            sum = sum*26 + s.charAt(i)-'A'+1;
        }
        return sum;
    }
    public static void main(String[] args){
        System.out.println(titleToNumber("ZY"));
    }
}