import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    //전깃줄
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int max = 0;

        thunder[] arr = new thunder[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new thunder(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr);

        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            if(dp[i] == 0)
                dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if(arr[i].b > arr[j].b && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(n - max);
    }

    static class thunder implements Comparable<thunder>{
        int a;
        int b;

        public thunder(int a, int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(thunder line){
            return Integer.compare(this.a, line.a);
        }
    }
}