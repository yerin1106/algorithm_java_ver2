package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.BufferUnderflowException;
import java.util.*;

public class BJ_1764_듣보잡 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();
        ArrayList<String> res = new ArrayList<>();

        for(int i=0; i<n; i++){
            set.add(br.readLine());
        }

        for(int i=0; i<m; i++){
            String b = br.readLine();
            if(set.contains(b)) res.add(b);
        }

        Collections.sort(res);
        System.out.println(res.size());
        for(int i=0; i<res.size(); i++){
            System.out.println(res.get(i));
        }
    }
}
