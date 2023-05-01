import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    //배
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int result = 0;
        int delNum = 0;

        ArrayList<Integer> crane = new ArrayList<>();
        ArrayList<Integer> box = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++)
            crane.add(Integer.parseInt(st.nextToken()));

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= M; i++)
            box.add(Integer.parseInt(st.nextToken()));

        int crainSize = crane.size()-1;
        int boxSize = box.size()-1;

        boolean[] check = new boolean[boxSize+5];

        Collections.sort(crane);
        Collections.sort(box);

        if(box.get(boxSize) > crane.get(crainSize)) {
            System.out.println(-1);
            return;
        }

        while(delNum <= boxSize){

            for(int i = 0; i <= crainSize; i++){
                boolean crainUse = false;

                for(int j = boxSize; j >= 0; j--){
                    if(!check[j] && box.get(j) <= crane.get(i)){
                        crainUse = true;
                        check[j] = true;
                        delNum++;
                        break;
                    }
                }

                if(!crainUse){
                    crane.remove(i);
                    crainSize--;
                    i--;
                }

            }
            result++;
        }

        System.out.println(result);
    }
}