import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long m = sc.nextLong();
        long k = sc.nextLong();

        System.out.println(Math.abs(n + m + k));
    }
}