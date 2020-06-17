import java.util.Scanner;

public class SubstringComparisons {

    static boolean isLarger(String a, String b){
        boolean larger = false;
        for (int i = 0; i < a.length() && i < b.length(); i++) {
            if(a.toCharArray()[i] > b.toCharArray()[i]){
                larger = true;
                break;
            }

            if(a.toCharArray()[i] < b.toCharArray()[i]){
                larger = false;
                break;
            }
        }
        return larger;
    }


    public static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0,k);
        String largest = s.substring(0,k);

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        for (int i = 0; i <= s.length()-k; i++) {
            if(SubstringComparisons.isLarger(smallest,s.substring(i,i+k))){
                smallest = s.substring(i,i+k);
            }
            if(SubstringComparisons.isLarger(s.substring(i,i+k),largest)){
                largest = s.substring(i,i+k);
            }
        }


        return smallest + "\n" + largest;
    }



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }

}





