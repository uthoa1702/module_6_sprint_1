package fibonacci;

public  class Fibonaccii {
    public static void main(String[] args) {
        int a = 0, b = 1, c;
        int sum = 0;


        for (int i = 0; i <= 100; i++) {
            c = a + b;
            if (c >= 100) {
                break;
            }
            if (isPrime(c)){
                sum = sum +c;
                System.out.print(" " + c + " ");

            }
            a = b;
            b = c;

        }
        System.out.println("");
        System.out.println(sum);
    }

    static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        if (count == 1) {
            return true;
        } else {
            return false;
        }
    }
}
