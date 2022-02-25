import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_2477_참외밭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        int[] length = new int[6];
        for(int i=0; i<6; i++){
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int cm = Integer.parseInt(st.nextToken());

            length[i] = cm;
        }

        int w=0,h=0;
        for(int i=0; i<6; i++){
            if(i%2 == 0){
                if(w<length[i]) w = length[i];
            }
            else{
                if(h<length[i]) h = length[i];
            }
        }

        int ww=0, hh=0;
        for(int i=0; i<6; i++){
            if(i%2==0){
                if(h == length[(i+5) % 6] + length[(i+1)%6]) ww = length[i];
            }
            else{
                if(w == length[(i+5) % 6] + length[(i+1)%6]) hh = length[i];
            }
        }

        System.out.println((w*h - ww*hh)*n);
    }
}
