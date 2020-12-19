package Middle;

class Solution165 {
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int flag = 1;
        if (arr1.length < arr2.length) {
            String[] tmp = arr1;
            arr1 = arr2;
            arr2 = tmp;
            flag = -1;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (i < arr2.length) {
                if (passInt(arr1[i]) > passInt(arr2[i])) {
                    return flag;
                } else if (passInt(arr1[i]) < passInt(arr2[i])) {
                    return -flag;
                }
            } else {
                if (passInt(arr1[i]) > 0) {
                    return flag;
                }
            }
        }
        return 0;
    }
    public int passInt(String s) {
        int rs = 0;
        for (int i = 0; i < s.length(); i++) {
            rs = rs * 10 + s.charAt(i) - '0';
        }
        return rs;
    }
}
