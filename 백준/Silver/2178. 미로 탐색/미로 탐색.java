
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class Pair {
        int r, c, dist;

        public Pair(int r, int c){
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    static Queue<Pair> que;
    private static final int[] DR = {1, 0, -1, 0};
    private static final int[] DC = {0, 1, 0, -1};
    static int[][] board;
    static boolean[][] vis;

    static int n;
    static int m;

    static int endR;
    static int endC;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        endR = n;
        endC = m;

        board = new int[n][m];
        vis = new boolean[n][m];

        for(int i = 0;i<n;i++){//입력받기
            String[] line = sc.next().split("");
            for(int j = 0;j<m;j++){
                board[i][j] = Integer.parseInt(line[j]);
            }
        }
        vis[0][0] = true;
        bfs(0,0);
    }

    public static void bfs(int row, int col){
        que = new LinkedList<>();

        que.add(new Pair(row,col));

        while(!que.isEmpty()){
            Pair cur = que.poll();

            for(int i = 0;i<4;i++){
                int nextR = cur.r + DR[i];
                int nextC = cur.c + DC[i];

                if(nextR<0 || nextR>= n||nextC <0|| nextC>=m){//BFS 조건
                    continue;
                }
                if(vis[nextR][nextC] || board[nextR][nextC] == 0) {
                    continue;
                }


                vis[nextR][nextC] = true;
                board[nextR][nextC] = board[cur.r][cur.c] + 1;
                que.add(new Pair(nextR,nextC));
            }

        }
        System.out.println(board[n-1][m-1]);
    }
}
