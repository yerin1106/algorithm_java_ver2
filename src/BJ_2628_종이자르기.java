import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_2628_종이자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> length = new ArrayList<>(); //세로
        ArrayList<Integer> width = new ArrayList<>(); //가로

        length.add(0);
        width.add(0);

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a == 0)
                length.add(b);
            else
                width.add(b);
        }

        length.add(y);
        width.add(x);

        Collections.sort(length);
        Collections.sort(width);

        //System.out.println(length);
        //System.out.println(width);

        int maxLegth = 0;
        for(int i=1; i<length.size(); i++){
            if(maxLegth < Math.abs(length.get(i-1) - length.get(i)))
                maxLegth = Math.abs(length.get(i-1) - length.get(i));
        }

        int maxWidth = 0;
        for(int i=1; i<width.size(); i++){
            if(maxWidth < Math.abs(width.get(i-1) - width.get(i)))
                maxWidth = Math.abs(width.get(i-1) - width.get(i));
        }

        System.out.println(maxLegth * maxWidth);
    }
}
