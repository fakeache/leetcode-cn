package Middle;

import java.util.List;

class NestedInteger1 {
 // Constructor initializes an empty nested list.
    public NestedInteger1() {
     
    }
    
    // Constructor initializes a single integer.
    public NestedInteger1(int value) {
     
    }
    
    // @return true if this NestedInteger1 holds a single integer, rather than a nested list.
    public boolean isInteger() {
     return false;
    }
    
    // @return the single integer that this NestedInteger1 holds, if it holds a single integer
    // Return null if this NestedInteger1 holds a nested list
    public Integer getInteger() {
        return 0;
    }
    
    // Set this NestedInteger1 to hold a single integer.
    public void setInteger(int value) {
    }
    
    // Set this NestedInteger1 to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger1 ni) {
     
    }
    
    // @return the nested list that this NestedInteger1 holds, if it holds a nested list
    // Return empty list if this NestedInteger1 holds a single integer
    public List<NestedInteger1> getList() {
     return null;
    }
}
public class Solution385 {
    public NestedInteger1 deserialize(String s) {
        int len = s.length();
        NestedInteger1 ni = new NestedInteger1();
        boolean isSon = false;
        int first = 1;
        int num = 0;
        int sidx = 0;
        int snum = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (!isSon) {
                if (c == '-') {
                    first = -1;
                } else if (Character.isDigit(c)) {
                    num = num * 10 + (c - '0');
                    if (i == len - 1) {
                        return new NestedInteger1(first * num);
                    }
                } else if ((c == ',' || c == ']') && Character.isDigit(s.charAt(i - 1))) {
                    ni.add(new NestedInteger1(first * num));
                    first = 1;
                    num = 0;
                } else if (i != 0 && c == '[') {
                    isSon = true;
                    sidx = i;
                }
            }
            if (isSon) {
                if (c == '[') {
                    snum++;
                } else if (c == ']') {
                    snum--;
                }
                if (snum == 0) {
                    String news = s.substring(sidx, i + 1);
                    ni.add(deserialize(news));
                    isSon = false;
                }
            }

        }
        return ni;
    }
}
