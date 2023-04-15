import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    //수 묶기
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] num=new int[n];

        int minus=0;
        for(int i=0;i<n;i++) {
            num[i]=Integer.parseInt(br.readLine());

            if(num[i]<=0)
                minus++;
        }

        Arrays.sort(num);

        int result=0;

        for(int i=1;i<minus;i+=2)
            result+=num[i-1]*num[i];


        if(minus%2==1)
            result+=num[minus-1];


        if((n-minus)%2==1)
            result+=num[minus];


        for(int i=n-1;i>minus;i-=2) {
            int sum=num[i]+num[i-1];
            int mul=num[i]*num[i-1];

            result += Math.max(sum, mul);
        }

        System.out.println(result);
    }
}