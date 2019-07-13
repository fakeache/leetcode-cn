package Simple;

import java.util.LinkedList;
import java.util.List;

public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> single = new LinkedList<>();
        if(numRows<0){
            return null;
        }
        if(numRows==0){
            return result;
        }
        single.add(1);
        result.add(single);
        if(numRows==1){
            return result;
        }
        for(int i=2;i<=numRows;i++){
            LinkedList<Integer> cur = new LinkedList<>();
            cur.add(1);
            for(int j=0;j<single.size()-1;j++){
                cur.add(single.get(j)+single.get(j+1));
            }
            cur.add(1);
            result.add(cur);
            single = cur;
        }
        return result;
    }
}