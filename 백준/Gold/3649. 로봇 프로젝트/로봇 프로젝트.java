import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    //로봇 프로젝트
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        while((s = br.readLine()) != null){

            int x = Integer.parseInt(s);

            int n = Integer.parseInt(br.readLine());

            int nanoX = x * 10000000;

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(arr);

            int abs = Integer.MIN_VALUE;

            int start = 0;
            int end = n-1;

            String answer = "danger";

            while(true){
                if(start>= end)
                    break;

                int sum = arr[start] + arr[end];

                if(sum == nanoX){
                    if(abs < Math.abs(arr[start] - arr[end])){
                        abs = Math.abs(arr[start] - arr[end]);
                        answer = "yes " + arr[start] + " " + arr[end];
                    }
                    start++;
                    end--;
                }else if(sum >= nanoX){
                    end--;
                }else{
                    start++;
                }

            }

            System.out.println(answer);
        }

    }
}