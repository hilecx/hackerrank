package Kangaroo;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the kangaroo function below.
    static String kangaroo(int x1, int v1, int x2, int v2) {

//        if(Math.abs(x2-x1)%Math.abs(v1-v2)==0){
//        Double s = (double)(x2-x1)/(double)(v1-v2);
        if(v1==v2 && x1!=x2){
            return "NO";
        }
//        Double s = Double.valueOf((x2-x1)/(v1-v2));
        Double s = (double)(x2-x1)/(double)(v1-v2);//注意精度问题！
        System.out.println(s+"|"+s.longValue());

        if(s == s.longValue() && s >= 0){
            return "YES";
        }else {
            return "NO";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println(new Double(-5.0));

        String[] x1V1X2V2 = scanner.nextLine().split(" ");

        int x1 = Integer.parseInt(x1V1X2V2[0]);

        int v1 = Integer.parseInt(x1V1X2V2[1]);

        int x2 = Integer.parseInt(x1V1X2V2[2]);

        int v2 = Integer.parseInt(x1V1X2V2[3]);

        String result = kangaroo(x1, v1, x2, v2);

        System.out.println(result);

        scanner.close();
    }
}
