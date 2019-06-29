package Simple;

public class Solution69 {
    //二分法，平方根在0和x/2+1之间
    //直接用mid*mid报错，因为可能超过int最大范围
    public static int mySqrt(int x) {
        if(x==0){
            return 0;
        }
        int low = 1;
        int high = (x/2)+1;
        int mid = 1;
        while(low<=high){
            mid =(low+high)/2;
            if(mid<=x/mid && (mid+1)>x/(mid+1)){
                return mid;
            }
            else if(mid>x/mid){
                high=mid-1;
            }
            else{
                low =mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int x = 1000000;
        System.out.println(mySqrt(x));
    }

}
