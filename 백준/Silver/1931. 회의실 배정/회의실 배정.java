import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    //회의실 배정

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());	// 시작시간
            arr[i][1] = Integer.parseInt(st.nextToken());	// 종료시간
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }else {
                    return o1[1] - o2[1];
                }
            }
        });
        
        int result = 0;
        int time = 0;

        for(int i = 0;i<n;i++){
            if(time <= arr[i][0]){
                time = arr[i][1];
                result++;
            }
        }

        System.out.println(result);
    }
}
