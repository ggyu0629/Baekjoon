import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //근손실

    static int n, k;
    static boolean[] vis;
    static int[] weight;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        weight = new int[n];
        vis = new boolean[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0);

        System.out.println(res);

    }

    static void dfs(int m,int depth){
        if(depth == n){
            res++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!vis[i] && m + weight[i] - k >= 0){
                vis[i] = true;
                dfs(m+weight[i]-k,depth+1);
                vis[i] = false;
            }
        }

    }
}