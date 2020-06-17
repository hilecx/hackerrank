package SherlocktheValidString;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid2(String s) {
        int[] c = new int[128];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i)]++;
        }
        System.out.println(Arrays.toString(c));
        int cnv = 0;
        int cn = 0;
        int c1 = 0;
        for (int i = 0; i < c.length - 1; i++) {
            if (c[i] > 0 && c[i] % 2 == 1 && c1 == 0) {
                c[i]--;
                c1++;
            }
            if (cnv == 0) {
                cnv = c[i];
            }

            if (c[i] != 0 && c[i] != cnv) {
                return "NO";
            }
        }
        return "YES";
//
//
//        int[] d = new int[s.length() + 1];//数组下标一定要小心！！
//        for (int i = 0; i < c.length; i++) {
//            if (c[i] != 0) {
//                d[c[i]]++;
//            }
//        }
//        System.out.println(Arrays.toString(d));
//
//        int countn = 0;
//        int count1 = 0;
//        for (int i = 0; i < d.length; i++) {
//            if (d[i] > 1) {
//                countn++;
//            }
//            if (d[i] == 1) {
//                count1++;
//            }
//        }
//        System.out.println(countn);
//        System.out.println(count1);
//        if (countn <= 1 && count1 <= 1) {
//            return "YES";
//        } else {
//            return "NO";
//        }
    }
//逻辑分支很多，要仔细分解！！
    static String isValid(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.get(c) == null ? 1 : map.get(c) + 1);
        }
        Map<Integer, Integer> cmap = new HashMap<>();
        for (Integer c : map.values()) {
            cmap.put(c,cmap.get(c)==null?1:cmap.get(c)+1);
        }
        if(cmap.size()>2){
            return "NO";
        }
        if(cmap.size()==1){
            return "YES";
        }
        if(cmap.size()==2){
            if(cmap.get(1)!=null && 1==cmap.get(1)){
                return "YES";
            }
            Integer[] count = new Integer[2];
            cmap.keySet().toArray(count);
            if(count[0]>count[1] && count[0]-count[1]==1 && cmap.get(count[0])==1){
                return "YES";
            }else if(count[1]>count[0] && count[1]-count[0]==1 && cmap.get(count[1])==1){
                return "YES";
            }
        }


        return "NO";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s = scanner.nextLine();

        String result = isValid(s);
        System.out.println(result);

        scanner.close();
    }
}
