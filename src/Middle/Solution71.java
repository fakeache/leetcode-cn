package Middle;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution71 {
    public static void main(String[] args) {
        String ss = "/";
        String[] ff = ss.split("/");
        System.out.println(ss.split("/").length);
        Deque<String> pathRs = new LinkedList<>();
        pathRs.push("1");
        pathRs.push("2");
        pathRs.add("3");
        System.out.println(Arrays.toString(pathRs.toArray()));

    }
}
