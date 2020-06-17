package NewYearChaos;

import java.io.*;
import java.math.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumBribes function below.
    static void minimumBribes1(int[] q) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("./out.txt"))) {
            writer.write("print('Hello World');");
            writer.write(System.lineSeparator());

            int jn = 0;
            int[] jc = new int[q.length + 1];
            int loopn = q.length;
            boolean switched = false;
            for (int i = 0; i <= q.length - 2; i++) {//i++是循环完成后执行的！！！
                writer.write(loopn + "--" + i + "---" + Arrays.toString(q));
                writer.write(System.lineSeparator());
                if (q[i] > q[i + 1]) {
                    jc[q[i]]++;
                    switchArray(q, i, i + 1);
                    jn++;
                    switched = true;
                }

                if (loopn == 0) {
                    break;
                } else if (i == q.length - 2) {
                    i = -1;
                    if (!switched) {
                        writer.write(Arrays.toString(jc));
                        writer.write(System.lineSeparator());
                        break;
                    }
                    switched = false;
                    loopn--;
                }
            }

            for (int i = 0; i <= jc.length - 1; i++) {
                if (jc[i] > 2) {
                    writer.write("Too chaotic");
                    writer.write(System.lineSeparator());
                    return;
                }
            }

            System.out.println(jn);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void minimumBribes2(int[] q) {
        int jn = 0;
        int[] jc = new int[q.length + 1];
        int loopn = q.length;
        boolean switched = false;
        for (int i = 0; i <= q.length - 2; i++) {
//            System.out.println(loopn+"--"+i+"---"+Arrays.toString(q));
            if (q[i] > q[i + 1] && jc[q[i]] < 2) {
                jc[q[i]]++;
                switchArray(q, i, i + 1);
                jn++;
                switched = true;
            }

            if (loopn == 0) {
                break;
            } else if (i == q.length - 2) {
                i = -1;
                if (!switched) {
//                    System.out.println(Arrays.toString(jc));
                    break;
                }
                switched = false;
                loopn--;
            }
        }

        for (int i = 0; i <= q.length - 2; i++) {
            if (q[i] > q[i + 1]) {
                System.out.println("Too chaotic");
                return;
            }
        }

        System.out.println(jn);

    }

    static void minimumBribes(int[] q) {
        int jn = 0;
        for (int i = q.length - 1; i >= 0; i--) {
            if (q[i] == i + 1) {
                continue;
            } else if (i > 0 && q[i - 1] == i + 1) {//i>0注意边界！！
                switchArray(q, i - 1, i);
                jn++;
            } else if (i > 1 && q[i - 2] == i + 1) {//i>1注意边界！！
                switchArray(q, i - 2, i - 1);
                switchArray(q, i - 1, i);
                jn = jn + 2;
            } else {
                System.out.println("Too chaotic");
                return;//第一次漏了，一定要细心啊
            }
        }
        System.out.println(jn);
    }

    private static void switchArray(int[] q, int i, int j) {
        int tmp = q[i];
        q[i] = q[j];
        q[j] = tmp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
