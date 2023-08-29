package kiem_tra_mang_doi_xung;

public class Demo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1,1};
        System.out.println(doiXung(arr));

    }

    public static boolean doiXung(int[] arr){
        int j = arr.length - 1;
        int count = 0;
        for (int i = 0; i < arr.length / 2;  i++, j--) {
            if (arr[i] == arr[j]){
                count++;
            }

        }
        if (count == arr.length / 2){
            return true;
        }
        return false;

    }
}
