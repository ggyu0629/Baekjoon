import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    //쉬운 최단거리

    static int[] DR = {0, 1, 0, -1};
    static int[] DC = {1, 0, -1, 0};

    static Queue<Pos> que;

    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        que = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                int temp = Integer.parseInt(st.nextToken());

                if(temp == 2) {
                    que.add(new Pos(i, j, 0));
                    map[i][j] = 0;
                    visited[i][j] = true;
                }else if(temp == 0){
                    visited[i][j] = true;
                    map[i][j] = temp;
                }else {
                    map[i][j] = temp;
                }
            }
        }

        while(!que.isEmpty()){
            Pos cur = que.poll();

            for (int i = 0; i < 4; i++) {
                int nextR = cur.r + DR[i];
                int nextC = cur.c + DC[i];
                int nextDist = cur.dist + 1;

                if(nextR >= 0 && nextR < n && nextC >= 0 && nextC <m){
                    if(!visited[nextR][nextC] && map[nextR][nextC] != 0){
                        map[nextR][nextC] = nextDist;
                        que.add(new Pos(nextR, nextC, nextDist));
                        visited[nextR][nextC] = true;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(visited[i][j]){
                    sb.append(map[i][j]).append(" ");
                }else{
                    sb.append(-1).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static class Pos{
        int r;
        int c;
        int dist;

        public Pos (int r, int c, int dist){
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
}