import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    //큰 수 만들기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        String[] arr = br.readLine().split(" ");

        Arrays.sort(arr,new bigNumComparator());

        for(String s : arr){
            sb.insert(0, s);
        }
        
        if(sb.toString().charAt(0) == '0')
            System.out.println(0);
        else 
            System.out.println(sb);
    }

    public static class bigNumComparator implements Comparator<String>{
        @Override
        public int compare(String o1, String o2){
            return (o1+o2).compareTo(o2+o1);
        }
    }
}