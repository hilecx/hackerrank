package search.MinimumTimeRequired;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minTime function below.
    static long minTime(long[] machines, long goal) {
        Arrays.sort(machines);
        long left = machines[0]*goal/machines.length;
        long right = machines[machines.length-1]*goal/machines.length;
        long mid = left+(right-left)/2;
        while (left<=right){
            long time = 0;
            for (int i = 0; i < machines.length; i++) {
                time += mid/machines[i];
            }
            if(left==right){
                return mid;
            }else if(time>goal){
                right=mid;
            }else if(time<goal){
                left=mid+1;
            }else if(time==goal){
                right=mid;
            }
            mid = left+(right-left)/2;
        }
        return left;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nGoal = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nGoal[0]);

        long goal = Long.parseLong(nGoal[1]);

        long[] machines = new long[n];

        String[] machinesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long machinesItem = Long.parseLong(machinesItems[i]);
            machines[i] = machinesItem;
        }

        long ans = minTime(machines, goal);

        System.out.println(ans);

        scanner.close();
    }
}
