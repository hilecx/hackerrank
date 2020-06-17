package RepeatedString;

import java.io.*;
import java.util.*;

public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        if (s == null || s.length()==0){
            return 0;
        }
        int na = 0;
        int[] la = new int[s.length()+1];
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a'){
                na++;
                la[i+1] = na;
            }else{
                la[i+1]=la[i];
            }

        }
        return na * (n/s.length()) + la[(int) (n%s.length())];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        System.out.println(result);

        scanner.close();
    }
}
