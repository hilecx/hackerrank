
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class JavaHashset {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String[] pair_left = new String[t];
        String[] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

        int count = 0;
        Set<String> stringSet = new HashSet<>();
        for (int i = 0; i < t; i++) {
            if(!stringSet.contains(pair_left[i]+" "+pair_right[i])){
                stringSet.add(pair_left[i]+" "+pair_right[i]);
                count++;
            }
            System.out.println(count);
        }


    }
}