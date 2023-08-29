import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'solve' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING s
     */

    public static int solve(int m, String s) {

        int counter = 0;
        for (int i = 0; i < m; i++) {

            for (int j = i + 1; j <= m; j++) {

                String strings = s.substring(i, j);

                if (isString(strings)) {

                    counter++;

                }
            }
        }


        return counter;
    }
    public static boolean isString(String str) {
        int i = 0;
        int[] arr = new int[100];
        for (char c : str.toCharArray()) {
            if (arr[c - 'A'] == 0) {
                i++;
            }
            arr[c - 'A']++;
        }
        return i == str.length();


    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = Result.solve(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
