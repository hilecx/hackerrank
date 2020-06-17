
import java.util.*;

public class JavaDequeue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();
        long max = 0;
        Map<Integer,Integer> countMap = new HashMap<>();
        Set<Integer> integerSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.addFirst(num);
            integerSet.add(num);
            System.out.printf("%d %d \n",deque.size(),integerSet.size());
            if (deque.size() > m) {
                int polled = deque.pollLast();
                if(!deque.contains(polled)){
                    integerSet.remove(polled);
                }
            }
//            long count = integerSet.size();
            long count = deque.parallelStream().distinct().count();
            max = max > count ? max : count;
        }
        System.out.println(max);
    }

}



