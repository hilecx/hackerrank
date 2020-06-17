package RecursionBacktracking.CrosswordPuzzle;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
//TODO: unfinished
public class Solution {

    static Set<Integer> usedWordIndices = new HashSet<>();

    // Complete the crosswordPuzzle function below.
    static String[] crosswordPuzzle(String[] crossword, String words) {
        String[] wordlist = words.split(";");
        char[][] cws = new char[crossword.length][crossword.length];
        for (int i = 0; i < crossword.length; i++) {
            for (int j = 0; j < crossword.length; j++) {
                cws[i][j] = crossword[i].charAt(j);
            }
        }

        for (int i = 0; i < wordlist.length; i++) {
            System.out.println("aaaaaaaaaaaaa"+i);
            String[] copiedwl = Arrays.copyOf(wordlist, wordlist.length);
            String tmp = copiedwl[i];
            copiedwl[i]=copiedwl[0];
            copiedwl[0]=tmp;
            char[][] copiedcw = deepCopy(cws);

            check(copiedcw, copiedwl);
        }
        for (int i = 0; i < cws.length; i++) {
            crossword[i] = new String(cws[i]);
        }
        return crossword;
    }

    static void check(char[][] crossword, String[] wordlist) {
        print(crossword);

        for (int i = 0; i < wordlist.length; i++) {

            if (wordlist[i] != null && judge(crossword, wordlist[i])) {
                wordlist[i] = null;
                check(crossword,wordlist);
            }
        }
        return;
    }

    static void print(char[][] crossword) {
        for (int i = 0; i < crossword.length; i++) {
            for (int j = 0; j < crossword[i].length; j++) {
                System.out.printf("%s", crossword[i][j]);
            }
            System.out.println();
        }
        System.out.println("=========================================");
    }

    static char[][] deepCopy(char[][] o){
        char[][] n = new char[o.length][];
        for (int i = 0; i < o.length; i++) {
            n[i] = new char[o[i].length];
            for (int j = 0; j < o[i].length; j++) {
                n[i][j]=o[i][j];
            }
        }
        return n;
    }

    static boolean judge(char[][] crossword, String word) {
        for (int i = 0; i < crossword.length; i++) {//行loop
            for (int j = 0; j < crossword[i].length; j++) {//列loop
                char cj = crossword[i][j];
                if (cj == '-' || cj == word.charAt(0)) {
                    boolean rowok = true;
                    boolean columnok = true;
                    //横向查找
                    if (j <= crossword[i].length - word.length()) {
                        for (int k = 0; k < word.length(); k++) {
                            if (crossword[i][j + k] != word.charAt(k) && crossword[i][j + k] != '-') {
                                rowok = false;
                            }
                            if(k==0 && j-1>=0 && crossword[i][j -1]!='+'){
                                rowok = false;
                            }
                            if(k==word.length()-1 && j+1<crossword[i].length && crossword[i][j -1]!='+'){
                                rowok = false;
                            }
                        }
                        if (rowok) {
                            for (int k = 0; k < word.length(); k++) {
                                if (crossword[i][j + k] == '-') {
                                    crossword[i][j + k] = word.charAt(k);
                                }
                            }
                            return true;
                        }
                    }
                    //纵向查找
                    if (!rowok && i <= crossword[i].length - word.length()) {
                        for (int k = 0; k < word.length(); k++) {
                            if (crossword[i + k][j] != word.charAt(k) && crossword[i + k][j] != '-') {
                                columnok = false;
                            }
                            if(k==0 && i-1>=0 && crossword[i-1][j]!='+'){
                                columnok = false;
                            }
                            if(k==word.length()-1 && i+1<crossword[i].length && crossword[i+1][j]!='+'){
                                columnok = false;
                            }
                        }
                        if (columnok) {
                            for (int k = 0; k < word.length(); k++) {
                                if (crossword[i + k][j] == '-') {
                                    crossword[i + k][j] = word.charAt(k);
                                }
                            }
                            return true;
                        }
                    }

                }
            }
        }
        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] crossword = new String[10];

        for (int i = 0; i < 10; i++) {
            String crosswordItem = scanner.nextLine();
            crossword[i] = crosswordItem;
        }

        String words = scanner.nextLine();

        String[] result = crosswordPuzzle(crossword, words);

        for (int i = 0; i < result.length; i++) {
            System.out.printf(result[i]);

            if (i != result.length - 1) {
                System.out.println();
            }
        }
        System.out.println();

        scanner.close();
    }
}
