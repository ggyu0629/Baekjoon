import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    //영우의 기숙사 청소

    static int[] DR = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] DC = {2, 1, -1, -2, -2, -1, 1, 2};

    static Queue<virus> que;
    static boolean[][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        que = new LinkedList<>();
        visited = new boolean[305][305][2];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            que.add(new virus(r, c, 0));
        }

        for (int i = 0; i < t; i++) {
            while(!que.isEmpty()&&que.peek().day==i%2){
                virus v = que.poll();
                for (int j = 0; j < 8; j++) {
                    int nextR = v.r + DR[j];
                    int nextC = v.c + DC[j];

                    if(nextR >= 1 && nextC >= 1 && nextR <= n && nextC <= n){
                        if(!visited[nextR][nextC][(i+1)%2])
                        {
                            que.add(new virus(nextR,nextC,(i+1)%2));
                            visited[nextR][nextC][(i+1)%2] = true;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            if(visited[r][c][t%2]){
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }

    static class virus{
        int r;
        int c;
        int day;

        public virus(int r, int c, int day){
            this.r = r;
            this.c = c;
            this.day =day;
        }
    }
}