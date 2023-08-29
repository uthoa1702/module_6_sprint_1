package fibonacci;

public class Fibonacci {
    public static void main(String[] args) {
        int a = 0, b = 1, c;
        System.out.print(a + " " + b);
        for (int i = 0; i <= 100; i++) {
            c = a + b;
            if (c >= 100) {
                break;
            }
            System.out.print(" " + c);
            a = b;
            b = c;
        }


    }

    public static boolean isPrime(int n) {
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
