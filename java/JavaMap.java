
//Complete this code or write your own from scratch

import java.util.*;
import java.io.*;

class JavaMap {
    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        Map<String,Integer> contact = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            int phone = in.nextInt();
            contact.put(name,phone);
            in.nextLine();
        }
        while (in.hasNext()) {
            String s = in.nextLine();
            Integer phone = contact.get(s);
            System.out.println(phone==null?"Not found":s+"="+phone);
        }
    }
}



