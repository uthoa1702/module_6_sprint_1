package mo_khoa;

import java.util.HashMap;
import java.util.Map;

public class MoKhoa {
    /*
    Khoá này sẽ có ~n~ ổ đĩa xoay gồm các số từ 0 đến 9. Mỗi lần xoay, anh ta có thể xoay tịnh tiến hoặc lùi về 1 số. Trong trường hợp số ở ổ đĩa đang là 9, nếu xoay tịnh tiến thì ổ đĩa sẽ trở về số 0, và ngược lại.

Tất nhiên là Leorio biết mật khẩu của cái khoá này. Cho trạng thái hiện tại của khoá xoay, hãy tính số lần xoay ít nhất để mở được khoá.

Input Format

Dòng đầu tiên là số nguyên   ứng với số bộ test.
Dòng thứ hai là số nguyên   chỉ số ổ đĩa xoay.
Hai dòng tiếp theo là chuỗi có độ dài  chỉ trạng thái của khoá xoay và mật khẩu của khoá.
Constraints

t \le 100
1 \le n \le 1000
Output Format

Với mỗi test, in ra một số duy nhất là kết quả của bài toán.
Sample Input 0

1
5
82195
64723
Sample Output 0

13
Explanation 0

Ổ đĩa 1: 8 -> 7 -> 6
Ổ đĩa 2: 2 -> 3 -> 4
Ổ đĩa 3: 1 -> 0 -> 9 -> 8 -> 7
Ổ đĩa 4: 9 -> 0 -> 1 -> 2
Ổ đĩa 5: 5 -> 4 -> 3
    * */
    public static void main(String[] args) {


    }

    public static int solve(int n, String a, String b) {
        String[] strings = a.split("");
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(strings[i]);
        }

        String[] strings1 = b.split("");
        int[] key = new int[n];
        for (int i = 0; i < n; i++) {
            key[i] = Integer.parseInt(strings1[i]);
        }
        Map<Integer, Integer> integerMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int c = arr1[i];
            int d = key[i];
            int count = 0;

            while (c != d) {
                count++;
                if (c == 9) {
                    c = 0;
                }else {
                    c++;
                }
            }
            integerMap.put(i, count);

        }

        for (int i = 0; i < n; i++) {
            int c = arr1[i];
            int d = key[i];
            int count = 0;

            while (c != d) {
                count++;
                if (c == 0) {
                    c = 9;
                }else {
                    c--;
                }
            }
            if (count < integerMap.get(i)){
                integerMap.put(i, count);
            }


        }
        int sum = 0;
        for (Integer e :
                integerMap.values()) {
            sum = sum +  e;
        }
        return sum;
    }
}
