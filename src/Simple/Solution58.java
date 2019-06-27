package Simple;

class Solution58 {
    public static int lengthOfLastWord(String s) {
        int len = s.length();
        int size= 0;
        int flag=0;

        for(int i=len-1;i>=0;i--){
            char c =s.charAt(i);
            if(flag==0){
                if(c!=' '){
                    flag=1;
                }
            }
            if(flag==1){
                if(c!=' '){
                    size++;
                }
                else{
                    break;
                }
            }
        }
        return size;
    }

    public static void main(String[] args){
        String ss = "  hi  brother  ";
        System.out.println(lengthOfLastWord(ss));
    }
}