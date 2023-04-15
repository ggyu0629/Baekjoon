import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    //대표 선수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<students> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                list.add(new students(i,Integer.parseInt(st.nextToken())));
            }
        }



        Collections.sort(list);


        int lp = 0;
        int rp = 0;
        int[] group = new int[n];
        int diff= Integer.MAX_VALUE;

        while (lp < n*m-1 && rp < n*m-1) {

            //모든 학급이 포함되도록 rp값 이동
            while (rp < n*m-1) {

                group[list.get(rp++).group]++;

                if(check(group))
                    break;
            }

            //모든 학급이 포함되도록 lp값 이동
            while (group[list.get(lp).group]>1) {
                group[list.get(lp++).group]--;
            }

            //모든 학급 포함시 값 갱신
            if(check(group)) {
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;

                for (int i = lp; i < rp; i++) {
                    min = Math.min(min, list.get(i).status);
                    max = Math.max(max, list.get(i).status);
                }
                diff = Math.min(diff, max-min);
            }

            //lp 오른쪽으로 한칸 이동
            group[list.get(lp++).group]--;

        }
        System.out.println(diff);

/*        for (int i = 0; i < n*m; i++) {
            System.out.println(list.get(i).group + " " + list.get(i).status);
        }*/

    }

    public static boolean check(int[] arr){
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == 0)
                return false;
        }
        return true;
    }

    static class students implements Comparable<students>{
        int group;
        int status;

        public students(int group, int status){
            this.group = group;
            this.status = status;
        }

        @Override
        public int compareTo(students students){
            if(students.status < status){
                return 1;
            }else if(students.status > status){
                return -1;
            }
            return 0;
        }
    }



}