import sun.font.FontRunIterator;

import java.util.Arrays;
import java.util.Scanner;

public class StringTokens {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
//        s= "He is a very very good boy, isn't he?";
        String s1 = s.trim();
        if(s1.length() == 0){
            System.out.println(0);
        }else {
            String[] ss = s1.split("[ !,?._'@]+");
//            System.out.println(Arrays.toString(ss));
            System.out.println(ss.length);
            for (int i = 0; i < ss.length; i++) {
                System.out.println(ss[i]);
            }
        }
        scan.close();
    }
}
