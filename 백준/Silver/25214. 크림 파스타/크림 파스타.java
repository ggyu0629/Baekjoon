import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    //크림 파스타
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];

        st = new StringTokenizer(br.readLine());

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            int target = Integer.parseInt(st.nextToken());

            if(min > target)
                min = target;

            if(i == 0)
                dp[i] = 0;
            else
                dp[i] = Math.max(dp[i-1], target - min);


        }

        for(int a : dp)
            sb.append(a).append(" ");

        System.out.println(sb);

    }
}