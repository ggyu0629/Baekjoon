import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //황소 다마고치
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());

            Long HP = Long.parseLong(st.nextToken());
            Long red = Long.parseLong(st.nextToken());

            long res = (long)(Math.log10(HP)/Math.log10(2) + 1) + red;

            System.out.println(res);

        }

    }
}