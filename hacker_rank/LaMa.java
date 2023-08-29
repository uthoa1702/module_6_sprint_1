import java.util.HashMap;
import java.util.Map;

public class LaMa {
    public static void main(String[] args) {
        String str = "IV";
        int a = sovle(str);
        System.out.println(a);
    }

    public static int sovle(String s) {
        Map<Character, Integer> integerMap = new HashMap<>();
        integerMap.put('I', 1);
        integerMap.put('V', 5);
        integerMap.put('X', 10);
        integerMap.put('L', 50);
        integerMap.put('C', 100);
        integerMap.put('D', 500);
        integerMap.put('M', 1000);

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int temp = integerMap.get(s.charAt(i));
            if (i < s.length() - 1 && integerMap.get(s.charAt(i)) < integerMap.get(s.charAt(i + 1))) {
                res = res - temp;
            } else {
                res = res + temp;
            }
        }
        System.out.println(res);
        return res;
    }
}
