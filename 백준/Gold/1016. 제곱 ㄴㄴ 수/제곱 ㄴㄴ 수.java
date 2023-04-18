import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //제곱 ㄴㄴ 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        int result = (int) (max - min + 1);

        boolean[] checks = new boolean[result];

        for(long i = 2; i <= Math.sqrt(max); i++) {
            long squared = i * i;

            if(min % squared == 0){
                for(long j = min / squared; j * squared <= max; j ++) {
                    checks[(int) ( (j * squared) - min)] = true;
                }
            }else{
                for(long j = (min / squared) + 1; j * squared <= max; j ++) {
                    checks[(int) ( (j * squared) - min)] = true;
                }
            }
        }


        int count = 0;
        for(int i = 0; i < result; i++) {
            if(!checks[i])
                count++;
        }

        System.out.println(count);
    }
}