
import java.math.BigDecimal;
import java.util.*;

class JavaBigDecimal {

    public static void main(String[] args) {
        //Input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n + 2];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        sc.close();

        //Write your code here
//        for (int i = 0; i < n - 1; i++) {
//            for (int j = 0; j < n - 1 - i; j++) {
//                System.out.println(s[j]+"---"+s[j+1]);
//                BigDecimal d1 = new BigDecimal(s[j]);
//                BigDecimal d2 = new BigDecimal(s[j+1]);
//                if(d1.compareTo(d2) < 0){
//                    String tmp = s[j];
//                    s[j] = s[j+1];
//                    s[j+1] = tmp;
//                }
//            }
//        }

//        Arrays.sort(s, new Comparator<String>() {
//            @Override
//            public int compare(String a1, String a2) {
//                BigDecimal a = new BigDecimal(a1);
//                BigDecimal b = new BigDecimal(a2);
//                return b.compareTo(a);
//            }
//        });

        Arrays.sort(s,0,n, new Comparator<String>() {
            @Override
            public int compare(String a1, String a2) {
                //convert to big decimal inside comparator
                //so permanent string values are never changed
                //aka you only use the BigDecimal values to
                //compare the strings!
                BigDecimal a = new BigDecimal(a1);
                BigDecimal b = new BigDecimal(a2);
                return b.compareTo(a);
            }
        });

        //Output
        for (int i = 0; i < n; i++) {
            System.out.println(s[i]);
        }
    }

}