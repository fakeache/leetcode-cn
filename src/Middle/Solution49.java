package Middle;

import java.util.*;

class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> rslist = new ArrayList<>();
        if (strs == null) {
            return rslist;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            String nstr = String.valueOf(strArr);
            List<String> list = map.getOrDefault(nstr, new ArrayList<>());
            list.add(str);
            map.put(nstr, list);
        }
        return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        Solution49 solution = new Solution49();
        System.out.println(solution.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}