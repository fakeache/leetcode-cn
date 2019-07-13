package Simple;

import java.util.LinkedList;
import java.util.List;

public class Solution119 {
    public static List<Integer> getRow(int rowIndex) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        if(rowIndex==0){
            return list;
        }
        for(int i=1;i<=rowIndex;i++){
            list.add(1);
            int a=list.poll();
            for(int j=0;j<i-1;j++){
                int b=list.poll();
                list.add(a+b);
                a=b;
            }
            list.add(1);
        }
        return list;
    }

    public static void main(String[] args){
        List<Integer> list = getRow(3);
        System.out.println(list);
    }
}