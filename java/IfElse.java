import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class IfElse {


    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String NOT_WEIRD="Not Weird";
    private static final String WEIRD="Weird";

    public static void main(String[] args) {
        int n = SCANNER.nextInt();
        SCANNER.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        SCANNER.close();

        if(Utils.isOdd(n)) {
            System.out.println(WEIRD);
        }else if(n>=2 && n<=5){
            System.out.println(NOT_WEIRD);
        }else if(n>=6 && n<=20){
            System.out.println(WEIRD);
        }else if(n>20){
            System.out.println(NOT_WEIRD);
        }
    }


}

class Utils {
    public static boolean isOdd(int n){
        return n%2==1?true:false;
    }
}