import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    //수 분해
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long res = 1;

        while (n >= 5) {
            n = n - 3;
            res = res * 3 % 10007;
        }

        res = res * n % 10007;

        System.out.println(res);
    }
}