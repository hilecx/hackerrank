
import java.io.*;
import java.util.*;

public class StringsIntroduction {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        /* Enter your code here. Print output to STDOUT. */
        System.out.println(A.length()+B.length());

        String isLarger = "No";
        for (int i = 0; i < A.length() && i < B.length(); i++) {
            if(A.toCharArray()[i] > B.toCharArray()[i]){
                isLarger = "Yes";
                break;
            }

            if(A.toCharArray()[i] < B.toCharArray()[i]){
                isLarger = "No";
                break;
            }
        }
        System.out.println(isLarger);

        System.out.println(StringsIntroduction.capitalizeFirstLetter(A)+" "+StringsIntroduction.capitalizeFirstLetter(B));


    }

    static String capitalizeFirstLetter(String s){
        char capitalizedChar = (char) ((int)s.toCharArray()[0] - 32);
        char[] chars = s.toCharArray();
        chars[0] = capitalizedChar;
        return new String(chars);
    }
}

