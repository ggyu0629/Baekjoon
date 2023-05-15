import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    //흙길 보수하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Pos[] wood = new Pos[n];

        int max = 0;
        
        for (int i = 0; i < n ; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            wood[i] = new Pos(start, end);
        }

        Arrays.sort(wood);

        int res = 0;

        for (Pos a : wood) {
            if (a.start > max) {
                max = a.start;
            }

            if (a.end > max) {
                while (a.end > max) {
                    max += l;
                    res++;
                }
            }
        }

        System.out.println(res);
    }

    static class Pos implements Comparable<Pos>{
        int start;
        int end;

        public Pos(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Pos o){
            if(this.start > o.start)
                return 1;
            else
                return -1;
        }
    }
}