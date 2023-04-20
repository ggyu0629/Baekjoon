import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    //버블 소트



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        sorting[] arr = new sorting[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = new sorting(Integer.parseInt(br.readLine()), i);
        }
        arr[0] = new sorting(Integer.MIN_VALUE, 0);
        Arrays.sort(arr);

        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            if(max < arr[i].index - (i-1))
                max = arr[i].index - (i-1);
        }

        System.out.println(max);
    }

    static class sorting implements Comparable<sorting> {
        int num;
        int index;

        public sorting(int num, int index){
            this.num = num;
            this.index = index;
        }

        @Override
        public int compareTo(sorting o){
            return Integer.compare(this.num, o.num);
        }
    }
}