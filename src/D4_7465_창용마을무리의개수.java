import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D4_7465_창용마을무리의개수 {

    static int[] parents;
    static int n;

    public static void makeSet(){
        parents = new int[n+1];

        for(int i=1; i<n+1; i++){
            parents[i] = i;
        }
    }

    public static int findSet(int a){
        if(a == parents[a]) return a;
        return parents[a] = findSet(parents[a]);
    }

    public static boolean union(int a, int b){
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if(aRoot == bRoot) return false;

        parents[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int tc = Integer.parseInt(br.readLine());
        for(int t=0; t<tc; t++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            makeSet();
            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            }

            int cnt = 0;
            for(int i=1; i<parents.length; i++){
                if(parents[i] == i) cnt++;
            }

            System.out.printf("#%d %d\n", t+1, cnt);
        }
    }
}

