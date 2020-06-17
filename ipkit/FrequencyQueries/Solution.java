package FrequencyQueries;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import static java.util.stream.Collectors.joining;

public class Solution {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(int[][] queries) {
        List<Integer> ans = new ArrayList<>(queries.length);
        Map<Integer, Integer> map = new HashMap<>(queries.length);
        Map<Integer, Integer> map2 = new HashMap<>(queries.length);
        Integer oper = null;
        Integer number = null;
        for (int i = 0; i < queries.length; i++) {
            oper = queries[i][0];
            number = queries[i][1];
            switch (oper) {
                case 1:
                    map2.compute(map.get(number), (key, value) -> value == null||value == 0 ? 0 : value - 1);
                    map.compute(number, (key, value) -> value == null ? 1 : value + 1);
                    map2.compute(map.get(number), (key, value) -> value == null||value == 0 ? 1 : value + 1);
                    break;
                case 2:
                    map2.compute(map.get(number), (key, value) -> value == null || value == 0 ? 0 : value - 1);
                    map.compute(number, (key, value) -> value == null || value == 0 ? value = 0 : value - 1);
                    map2.compute(map.get(number), (key, value) -> value == null || value == 0 ? 1 : value + 1);
                    break;
                case 3:
                    ans.add(map2.get(number) == null || map2.get(number) == 0 ? 0 : 1);
                    break;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int q = Integer.parseInt(bufferedReader.readLine().trim());
            int[][] queries = new int[q][2];
            Pattern p = Pattern.compile("^(\\d+)\\s+(\\d+)\\s*$");
            for (int i = 0; i < q; i++) {
                Matcher m = p.matcher(bufferedReader.readLine());
                if (m.matches()) {
                    queries[i][0] = Integer.parseInt(m.group(1));
                    queries[i][1] = Integer.parseInt(m.group(2));
                }
            }
            List<Integer> ans = freqQuery(queries);

            try (BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter(System.getenv("OUTPUT_PATH")))) {

                bufferedWriter.write(ans.stream().map(Object::toString)
                        .collect(joining("\n")) + "\n");
            }

            for (int i = 0; i < ans.size(); i++) {
                System.out.printf(String.valueOf(ans.get(i)));

                if (i != ans.size() - 1) {
                    System.out.println();
                }
            }

        }
    }
}
