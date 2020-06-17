
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class JavaBigInteger {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        BigInteger ba = new BigInteger(a);
        BigInteger bb = new BigInteger(b);
        System.out.println(ba.add(bb));
        System.out.println(ba.multiply(bb));

        scanner.close();

    }
}

