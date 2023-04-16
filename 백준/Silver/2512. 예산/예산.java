import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    //예산
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        st = new StringTokenizer(br.readLine());

        int max = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        int m = Integer.parseInt(br.readLine());
        int left = 0;

        while(left<=max) {
            int mid = (left+max)/2;
            long sum =0;

            for(int i=0; i<n; i++) {
                sum += Math.min(arr[i], mid);
            }

            if(sum<=m) {
                left = mid+1;
            }else {
                max = mid-1;
            }
        }

        System.out.println(max);

        
    }
}