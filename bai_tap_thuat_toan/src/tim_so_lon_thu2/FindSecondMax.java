package tim_so_lon_thu2;

import java.util.*;

public class FindSecondMax {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(13);
        integerList.add(10);
//        System.out.println(findSecond(4,integerList));
        String a = "java2s";
        a.replace('a','Z').trim().concat("Aa");
        a.substring(0,2);
        System.out.println(a);
    }
    public static int findSecond(int n, List<Integer> numbers){
        int y = -1;
        TreeSet<Integer> integerSet = new TreeSet<>();
        for (int i = 0; i <  numbers.size(); i++){
            integerSet.add(numbers.get(i));

        }
        int res = integerSet.lower(integerSet.last());

        for (int i = 0; i < numbers.size(); i++) {
            if (res == numbers.get(i)){
               y =  i;
            }
        }
        return y;

    }
}
