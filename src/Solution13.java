class Solution13 {
    public  static int getValue(char c){
        switch (c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return -1;
        }
    }
    public int romanToInt(String s) {
        int rs=0;
        char[] arr = s.toCharArray();
        int before=0;
        int after=Solution13.getValue(arr[0]);
        for(int i=0; i<arr.length-1;i++){
            before= after;
            after= Solution13.getValue(arr[i+1]);
            if(before<after){
                rs=rs-before;
            }
            else {
                rs=rs+before;
            }
        }
        rs=rs+Solution13.getValue(arr[arr.length-1]);
        return rs;
    }
}