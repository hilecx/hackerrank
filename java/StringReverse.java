import java.util.Scanner;

public class StringReverse {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        char[] chars = A.toCharArray();
        String isPalindrome = "Yes";
        for (int i = 0; i < (A.length()+1)/2; i++) {
            if(chars[i] != chars[A.length()-i-1]){
                isPalindrome = "No";
                break;
            }
        }
        System.out.println(isPalindrome);
    }
}
