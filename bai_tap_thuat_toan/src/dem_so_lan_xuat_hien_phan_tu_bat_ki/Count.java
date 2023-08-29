package dem_so_lan_xuat_hien_phan_tu_bat_ki;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Count {
    public static void main(String[] args) {
        /*"Cho 1 chuỗi, lấy ra số lần xuất hiện của các ký tự có trong chuỗi.
Ví dụ: ""aabacsdc"" : 3a,1b,2c,1d,1s"*/
        String arr = "aaaabbccd";

        Map<Character, Integer> characterIntegerMap = new HashMap<>();

        for (int i = 0; i < arr.length(); i++) {
            if (characterIntegerMap.containsKey(arr.charAt(i))){
                int count = characterIntegerMap.get(arr.charAt(i));
                characterIntegerMap.put(arr.charAt(i), count + 1);
            }
            else {
                characterIntegerMap.put(arr.charAt(i), 1);
            }
        }
            System.out.println(characterIntegerMap.entrySet());
    }
}
