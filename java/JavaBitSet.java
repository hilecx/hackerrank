
import java.io.*;
import java.util.*;

public class JavaBitSet {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int n = in.nextInt();
        in.nextLine();
        BitSet b1 = new BitSet(length);
        BitSet b2 = new BitSet(length);

        for (int i = 0; i < n; i++) {
            String opt = in.next();
            int s1 = in.nextInt();
            int s2 = in.nextInt();
            in.nextLine();
            switch (opt) {
                case "SET":
                    if (s1 == 1) {
                        b1.set(s2, true);
                    }
                    if (s1 == 2) {
                        b2.set(s2, true);
                    }
                    break;
                case "FLIP":
                    if (s1 == 1) {
                        b1.flip(s2);
                    }
                    if (s1 == 2) {
                        b2.flip(s2);
                    }
                    break;
                case "AND":
                    if (s1 == 1) {
                        b1.and(b2);
                    }
                    if (s1 == 2) {
                        b2.and(b1);
                    }
                    break;
                case "OR":
                    if (s1 == 1) {
                        b1.or(b2);
                    }
                    if (s1 == 2) {
                        b2.or(b1);
                    }
                    break;
                case "XOR":
                    if (s1 == 1) {
                        b1.xor(b2);
                    }
                    if (s1 == 2) {
                        b2.xor(b1);
                    }
                    break;
            }

            System.out.printf("%d %d",b1.cardinality(),b2.cardinality());

        }

        in.close();
    }
}

