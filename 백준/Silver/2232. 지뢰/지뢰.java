import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
    //지뢰
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        List<Integer> res = new ArrayList<>();

        if(n==1){
            System.out.println(1);
            return;
        }

        for (int i = 0; i < n; i++) {
            if(i == 0){
                if(arr[i] >= arr[i+1]){
                    res.add(i+1);
                }
            }else if(i == n-1){
                if(arr[i-1] <= arr[i]){
                    res.add(i+1);
                }
            }else{
                if(arr[i] >= arr[i-1] && arr[i] >= arr[i+1]){
                    res.add(i+1);
                }
            }
        }

        for(int a : res)
            System.out.println(a);

    }

}