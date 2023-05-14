import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n;
    static Queue<String> q;
    static String[] dc = {"1", "0"};
    static boolean[] same;

    static BigInteger bi;
    static BigInteger bn;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());

            if(n == 1) {
                System.out.println(1);
                continue;
            }
            
            BFS();
        }

    }

    static void BFS(){

        q = new LinkedList<>();

        q.add("1");
        same = new boolean[n+1];// n == 17일 떄 17까지 나머지가 가능

        while (!q.isEmpty()) {
            String temp = q.poll();

            for (int i = 0; i < 2; i++) {
                String nt = temp + dc[i];

                bi = new BigInteger(nt);
                bn = new BigInteger(String.valueOf(n));

                int tmp = Integer.MAX_VALUE;

                while (tmp >= n) {
                    tmp = Integer.parseInt(String.valueOf(bi.remainder(bn)));
                }

                if(tmp == 0) {
                    System.out.println(nt);
                    return;
                }

                if(same[tmp])
                    continue;

                same[tmp] = true;

                q.add(nt);

            }

        }
    }
}