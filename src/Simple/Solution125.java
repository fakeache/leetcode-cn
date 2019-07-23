package Simple;

class Solution125 {
    public static boolean isPalindrome(String s) {
        if(s==null){
            return false;
        }
        int i=0,j=s.length()-1;
        while(i<=j){
            char a = ' ';
            while(i<=j){
                if(s.charAt(i)>='a' && s.charAt(i)<='z'){
                    a = s.charAt(i);
                    break;
                }
                else if(s.charAt(i)>='A' && s.charAt(i)<='Z'){
                    a = (char)(s.charAt(i) - 'A' + 'a');
                    break;
                }
                else if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                    a = s.charAt(i);
                    break;
                }
                else{
                    i++;
                }
            }
            char b = ' ';
            while(i<=j){
                if(s.charAt(j)>='a' && s.charAt(j)<='z'){
                    b = s.charAt(j);
                    break;
                }
                else if(s.charAt(j)>='A' && s.charAt(j)<='Z'){
                    b = (char)(s.charAt(j) - 'A' + 'a');
                    break;
                }
                else if(s.charAt(j)>='0' && s.charAt(j)<='9'){
                    b = s.charAt(j);
                    break;
                }
                else{
                    j--;
                }
            }
            if(a!=b){
                return false;
            }
            else{
                i++;
                j--;
            }
        }
        return true;
    }

    public static void main(String[] args){
        String ss = "1b1";
        System.out.println(isPalindrome(ss));
    }
}