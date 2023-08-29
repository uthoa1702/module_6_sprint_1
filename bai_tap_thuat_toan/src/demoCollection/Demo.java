package demoCollection;

import java.util.*;

public class Demo {


    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(1);
        integerList.add(2);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);

//        System.out.println(integerList);?


        LinkedHashSet<Integer> integerSet = new LinkedHashSet<>();
        integerSet.add(1);
        integerSet.add(20);
        integerSet.add(21);
        integerSet.add(32);
        integerSet.add(40);
        integerSet.add(5);
        integerSet.add(6);
        integerSet.add(7);
        integerSet.add(8);
        integerSet.add(9);

        System.out.println(integerSet);




    }
}
