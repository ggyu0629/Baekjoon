import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //개똥벌레
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] top = new int[h+1];// 종유석
        int[] bottom = new int[h+1];// 석순

        for(int i = 0;i<n/2;i++){
            int suk = Integer.parseInt(br.readLine());
            int jong = Integer.parseInt(br.readLine());

            top[jong]++;
            bottom[h-suk]++;
        }

        for(int i = h;i>1;i--){
            top[i-1] += top[i];
        }

        for(int i = 0;i< h-1;i++){
            bottom[i+1] += bottom[i];
        }

        int[] sum = new int[h];
        int min = Integer.MAX_VALUE, res = 1;

        for (int i = 1; i <= h; i++) {
            sum[i-1] = top[i] + bottom[i-1];
            if(sum[i-1] < min){
                min = sum[i-1];
                res = 1;
            }else if(sum[i-1] == min)
                res++;
        }

        System.out.println(min + " " + res);
    }

}