import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    //N과 M(6)

    static int[] arr;
    static int[] num;
    static boolean[] vis;
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        num = new int[n];
        vis = new boolean[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        dfs(0,0);
        System.out.println(sb);
    }

    public static void  dfs(int index, int cnt){
        if(cnt == m){
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = index; i < n; i++) {
            if(!vis[i]){
                vis[i] = true;
                arr[cnt] = num[i];
                dfs(i,cnt + 1);
                vis[i] = false;
            }

        }
    }
}