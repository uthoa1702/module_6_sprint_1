package fibonacci;

import java.util.ArrayList;
import java.util.List;

public class LamLai {
    public static void main(String[] args) {
        int a = 0, b = 1, c;
        List<Integer>integerList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            c = a + b;
            if (c > 100){
                break;
            }
            int count = 0;
            for (int j = 2; j <= c; j++) {
                if (c % j == 0){
                    count++;
                }

            }
            if (count == 1){
                integerList.add(c);
            }
            a = b;
            b = c;
        }
        for (int i = 0; i < integerList.size(); i++) {
            System.out.println(integerList.get(i));
        }


    }

}