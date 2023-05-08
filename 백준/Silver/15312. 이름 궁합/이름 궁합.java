import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    //이름 궁합
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String he = br.readLine();
        String she = br.readLine();

        int[] alpha = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
        int[][] dp = new int[he.length()*2][he.length()*2];

        for (int i = 0; i < she.length()*2; i++) {
            char c;
            if(i%2 == 0)
                c = he.charAt(i/2);
            else
                c = she.charAt(i/2);

            int hn = (int) c - 64;

            dp[0][i] = alpha[hn-1];

        }

        for (int i = 0; i < he.length()*2-2; i++) {
            for (int j = 0; j < he.length()*2-1-i; j++) {
                dp[i+1][j] = (dp[i][j] + dp[i][j+1]) % 10;
            }
        }

        sb.append(dp[she.length()*2-2][0]).append(dp[she.length()*2-2][1]);

        System.out.println(sb);

    }
}