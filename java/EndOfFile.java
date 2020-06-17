import java.util.Scanner;

public class EndOfFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 1;
        String input = "";
        while(sc.hasNext()){
            input = sc.nextLine();
            System.out.printf("%d %s\n",i++,input);

        }
    }
}
