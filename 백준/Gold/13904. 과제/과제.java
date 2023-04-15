import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    //과제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        List<assignment> list = new ArrayList<>();

        int high_Day = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            list.add(new assignment(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
            high_Day = Math.max(high_Day, list.get(i).day);
        }

        int res = 0;
        
        for (int i = high_Day; i > 0 ; i--) {
            int index = -1;
            int tempScore = 0;

            for (int j = 0; j < list.size(); j++) {
                if(i <= list.get(j).day){
                    if(list.get(j).score > tempScore){
                        index = j;
                        tempScore = list.get(j).score;
                    }
                }
            }

            if(index != -1) {
                res = res + list.get(index).score;
                list.remove(index);
            }

        }

        System.out.println(res);

    }

    static class assignment{
        int day;
        int score;

        public assignment(int day, int score){
            this.day = day;
            this.score = score;
        }
    }
}