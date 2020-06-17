
import java.util.*;

public class Java1DArray2 {

    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        System.out.println(leap + " " + Arrays.toString(game));
        boolean isSuccess = true;
        int n = game.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += game[i];
        }
        if (leap == 0 && sum > 0) {
            return false;
        }
        if (leap == 0 && sum == 0) {
            return true;
        }

        for (int i = 0; i < n; i++) {
            int leapTo = i + leap;
            if (leapTo > n) {
                break;
            }
            if (leapTo < n && game[i] + game[leapTo] == 0) {
                int leapstart = leapTo;
                for (int j = leapTo - 1; j > 0; j--) {
                    if (game[j] == 1) {
                        leapstart = j + 1;
                        break;
                    }
                }
                isSuccess = canWin(leap, Arrays.copyOfRange(game, leapstart, n));
                if (isSuccess) {
                    break;
                } else {
                    game[i] = 1;
                    continue;
                }
            } else if (game[i] == 1) {
                isSuccess = false;
                break;
            }
        }
        return isSuccess;
    }

    private static boolean isSolvable(int m, int[] arr, int i) {
        System.out.printf("%d %d ", m, i);
        System.out.println(Arrays.toString(arr));
        if (i < 0 || arr[i] == 1) return false;
//        if (i + m >= arr.length - 1) return true;
        if ((i == arr.length - 1) || i + m > arr.length - 1) return true;

        arr[i] = 1;
        return isSolvable(m, arr, i + 1) || isSolvable(m, arr, i - 1) || isSolvable(m, arr, i + m);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();

            }


            System.out.println("q:" + q);
//            System.out.println((canWin(leap, game)) ? "YES" : "NO");
            System.out.println( (isSolvable(leap, game,0)) ? "YES" : "NO");
        }
        scan.close();

    }
}

