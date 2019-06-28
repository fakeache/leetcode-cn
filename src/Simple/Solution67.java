package Simple;

import java.util.Arrays;

class Solution67 {
    public static String addBinary(String a, String b) {
        String longStr = a.length()>b.length()?a:b;
        String shortStr = a.length()>b.length()?b:a;
        int length = longStr.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<longStr.length()-shortStr.length();i++){
            sb.append('0');
        }
        sb.append(shortStr);
        shortStr = sb.toString();
        int z = 0;//进位
        StringBuilder rs = new StringBuilder();
        for(int j=length-1;j>=0;j--){
            int x = longStr.charAt(j)-'0';
            int y = shortStr.charAt(j)-'0';
            if(x+y+z == 0){
                rs.insert(0, '0');
                z=0;
            }
            else if(x+y+z == 1){
                rs.insert(0, '1');
                z=0;
            }
            else if(x+y+z == 2){
                rs.insert(0, '0');
                z=1;
            }
            else{
                rs.insert(0, '1');
                z=1;
            }
        }
        if(z==1){
            rs.insert(0, '1');
        }
        return rs.toString();
    }

    public static void main(String[] args){
        String a = "11";
        String b = "1";
        System.out.println(addBinary(a, b));
    }
}