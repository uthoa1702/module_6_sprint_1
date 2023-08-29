import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Result {


    /*
     * Complete the 'decode' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING encodedContent
     *  2. INTEGER key
     */

    public static String decode(String encodedContent, int key) {
        // Write your code here
        char[] encode = encodedContent.toCharArray();

        for (int i = 0; i < key / 2; i++) {
            char temp;
            temp = encode[i];
            encode[i] = encode[(key - 1) - i];
            encode[(key - 1) - i] = temp;
        }
        int j = 0;
        int tru = (encode.length - key) / 2;
        for (int i = encode.length - 1; i >= key; i--) {
            if (j < tru) {
                char temp;
                temp = encode[i];
                encode[i] = encode[key + j];
                encode[key + j] = temp;
                j++;
            }
        }
        String res = new String(encode);
        System.out.println(res);
        return res;

    }

    public static String decodee(String encodedContent, int key) {
        String str = new String();
        for (int i = key - 1; i >= 0; i--) {
            str += encodedContent.charAt(i);
        }
        for (int i = encodedContent.length() - 1; i >= key; i--) {
            str += encodedContent.charAt(i);
        }
        return str;
    }

    public static int add(int n, List<Integer> numbers) {

        if (n <= 1){
            return 0;
        }
        if (numbers.size() < 2){
            return 0;
        }

        if (n > 0 && numbers.size() > 1){
            for (int i = 0; i < numbers.size() - 1; i++) {
                 if (numbers.get(i+1) - numbers.get(i) != n){
                     return 0;
                 }
            }
            return 1;
        }
        return 0;

    }


}

public class Solution {
    public static void main(String[] args) {
//        Result.decode("margorpgnim", 7);
//        System.out.println(Result.decode("21543", 2));
        int[] arr = {2,4,6,1};
//        System.out.println(Result.add(2,arr));
    }
}
