package Simple;

class Solution28 {
    public static int strStr(String haystack, String needle) {
        if(needle==null || needle.length()==0){
            return 0;
        }
        int nlen=needle.length();
        int hlen=haystack.length();
        for(int i=0;i<=hlen-nlen;i++){
            for(int j=0;j<nlen;j++){
                if(haystack.charAt(i+j)!=needle.charAt(j)){
                    break;
                }
                if(j==nlen-1){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        String a = "hello";
        String b = "lo";
        System.out.println(strStr(a, b));
    }
}