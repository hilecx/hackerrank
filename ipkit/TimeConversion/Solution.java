package TimeConversion;

import java.io.*;
import java.math.*;
import java.text.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     * Note:
     * Midnight is 12:00:00AM on a 12-hour clock, and 00:00:00 on a 24-hour clock.
     * Noon is 12:00:00PM on a 12-hour clock, and 12:00:00 on a 24-hour clock.
     */
    static String timeConversion2(String s) {
        /*
         * Write your code here.
         */
        if(s.substring(0,2).equals("12") && s.substring(s.length()-2,s.length()).equals("AM")){
            s = "00"+s.substring(2);
        }
        s =s.replace("AM","");
        DecimalFormat decimalFormat = new DecimalFormat("00");
        if(s.contains("PM")){
            String h = decimalFormat.format(Integer.valueOf(s.substring(0,2))+12);
            if(h.equals("24")){
                h="12";
            }
            s = h + s.substring(2,s.length()-2);
        }

        return s;

    }

    static String timeConversion(String s) {
        // 注意设置local（Locale.ENGLISH），否则默认中国，打印出：上午 下午
        LocalTime localTime = LocalTime.parse(s, new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("hh:mm:ssa").toFormatter(Locale.ENGLISH));
        return localTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

        private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        LocalTime localTime =  LocalTime.of(17, 23, 52);
        System.out.println(localTime.format(DateTimeFormatter.ofPattern("HH:mm:ssa").withLocale(Locale.ENGLISH)));

        String s = scan.nextLine();

        String result = timeConversion(s);

        System.out.println(result);

    }
}
