import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Pos{
        int r, c, dist;

        public Pos(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    static Queue<Pos> beaver = new LinkedList<>();

    private static final int[] DR = {1, 0, -1, 0};
    private static final int[] DC = {0, 1, 0, -1};

    static char[][] map;

    static boolean[][] visit_beaver;

    static int r;
    static int c;

    static int cnt;
    static Pos end;
    static Pos start;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];

        visit_beaver = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j] == '*')
                    beaver.add(new Pos(i, j, 0));
                if(map[i][j] == 'D')
                    end = new Pos(i, j, 0);
                if(map[i][j] == 'S') {
                    start = new Pos(i, j, 0);
                    visit_beaver[start.r][start.c] = true;
                }
            }
        }

        if(bfs())
            System.out.println(cnt);
        else
            System.out.println("KAKTUS");


    }

    public static boolean bfs(){
        beaver.add(start);

        while(!beaver.isEmpty()) {
            Pos p = beaver.poll();

            if(p.r == end.r && p.c == end.c){
                cnt = p.dist;
                return true;
            }

            if(map[p.r][p.c] == '*'){
                for (int d = 0; d < 4; d++) {
                    int nextR = p.r + DR[d];
                    int nextC = p.c + DC[d];

                    if(nextR<0 || nextR>= r||nextC <0|| nextC>=c){//BFS 조건
                        continue;
                    }

                    if(visit_beaver[nextR][nextC])
                        continue;

                    if(map[nextR][nextC] == 'X' || map[nextR][nextC] == 'D') {
                        continue;
                    }

                    visit_beaver[nextR][nextC] = true;
                    map[nextR][nextC] = '*';
                    beaver.add(new Pos(nextR, nextC, p.dist + 1));
                }
            }else{
                for (int d = 0; d < 4; d++) {
                    int nextR = p.r + DR[d];
                    int nextC = p.c + DC[d];

                    if(nextR<0 || nextR>= r||nextC <0|| nextC>=c){//BFS 조건
                        continue;
                    }

                    if(visit_beaver[nextR][nextC])
                        continue;

                    if(map[nextR][nextC] == 'X' || map[nextR][nextC] == '*') {
                        continue;
                    }

                    visit_beaver[nextR][nextC] = true;
                    beaver.add(new Pos(nextR, nextC, p.dist + 1));
                }
            }

        }

        return false;
    }
}