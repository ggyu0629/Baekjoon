import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    //공유기 설치

    static int[] house;
    static int n;
    static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        house = new int[n];

        for (int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        binarySearch();

    }

    static void binarySearch(){

        int start = 1;//0이상의 최소거리.
        int end = house[n-1] - house[0] + 1;
 
        while(start < end){
            int mid = (start + end) / 2;

            if(install(mid) < c)
                end = mid;
            else{
                start = mid + 1;
            }
        }

        System.out.println(start - 1);
    }

    static int install(int distance){

        int location = house[0];//항상 1번집에 심는다고 가정.
        int cnt = 1;// 1번집은 설치했으므로 1시작.

        for(int i = 1; i < n; i++) {
            int tempLocation = house[i];

            if(tempLocation - location >= distance) {
                cnt++;
                location = tempLocation;
            }
        }

        return cnt;
    }

}