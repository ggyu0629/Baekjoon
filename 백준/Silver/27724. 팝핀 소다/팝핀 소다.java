import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //팝핀소다
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int cnt = 0;

        while(true){
            if(k <= 1)
                break;
            k = k / 2;

            cnt++;
        }

        int twoCnt = 0;

        while(true){
            if(n == 1)
                break;

            n = n /2;
            twoCnt++;
        }

        if(twoCnt < cnt + m)
            cnt = twoCnt;
        else
            cnt = cnt + m;

        System.out.println(cnt);

    }
}