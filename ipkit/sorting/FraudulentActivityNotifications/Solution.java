package sorting.FraudulentActivityNotifications;

import javax.sound.midi.Soundbank;
import javax.swing.text.html.HTMLDocument;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Pair{
    public Integer index;
    public Integer value;

    public Pair(Integer index, Integer value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return Objects.equals(index, pair.index);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "index=" + index +
                ", value=" + value +
                '}';
    }
}

public class Solution {

    static void LinkedListAddInOrder(LinkedList<Pair> linkedList,Pair pair){


    }


    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        LinkedList<Pair> linkedList = new LinkedList(){
            public boolean add(Pair e) {
                System.out.println(e);
                return true;
            };
        };
        linkedList.add(new Pair(1,1));

        int nc = 0;

        long copytime = 0;
        long sorttime = 0;

        PriorityQueue<Pair> p = new PriorityQueue<>(new Comparator<Pair>(){

            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.value-o2.value;
            }
        });
        for (int i = 0; i < d; i++) {
            p.add(new Pair(i,expenditure[i]));
        }

        int ps = p.size();
//        for (int i = 0; i < ps; i++) {
//            System.out.println(p.poll());
//        }
        Iterator iterator = p.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


        for (int i = d; i < expenditure.length; i++) {
            Pair m;
            double mv = findMidValue(p,d);
//            long a= System.currentTimeMillis();
//            Pair[] t =  p.toArray(new Pair[0]);
//            long b= System.currentTimeMillis();
//            copytime+=b-a;
//            long c= System.currentTimeMillis();
//            sorttime+=c-b;


            if (expenditure[i] >= mv*2) {
                nc++;
            }
            p.remove(new Pair(i-d,expenditure[i-d]));
            p.add(new Pair(i-d,expenditure[i]));
        }
        System.out.printf("copytime:%d sorttime:%d \n",copytime,sorttime);
        return nc;
    }

    public static double findMidValue(PriorityQueue<Pair> p, Integer d){

        int midIndex = d / 2;
        boolean isOdd = d % 2 == 1;
        double mv;
        if (isOdd) {
            for (int i = 0; i < d; i++) {

                if(i==midIndex){
                    mv =p.poll().value;
                    return mv;
                }else {
                    p.poll();
                }
            }
        } else {
            for (int i = 0; i < d; i++) {

                if(i==midIndex){
                    mv =p.poll().value;
                    mv = (mv+p.poll().value)/2;
                    return mv;
                }else {
                    p.poll();
                }
            }
        }
        return 0;
    }



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);
        System.out.println(result);

        scanner.close();
    }
}
