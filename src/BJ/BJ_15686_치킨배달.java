package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_15686_치킨배달 {
    static int n, m;
    static int size;
    static int[] num;
    static int[] arr;
    static ArrayList<int[]> chicken;
    static int[][] map;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        chicken = new ArrayList<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    int[] tmp = {i, j};
                    chicken.add(tmp);
                }
            }
        }

        //combination(chicken size만큼)
        size = chicken.size();

        arr = new int[size];
        for(int i=0; i<size; i++){
            arr[i] = i;
        }

        num = new int[m];

        combination(0, 0);
        System.out.println(min);

    }

    public static void combination(int cnt, int start){
        if(cnt == m){
            int ans = 0;

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(map[i][j] == 1){
                        int tmp = Integer.MAX_VALUE;
                        for(int k=0; k<m; k++){
                            int[] store = chicken.get(num[k]);
                            int distance = Math.abs(store[0]-i) + Math.abs(store[1]-j);
                            if(tmp > distance) tmp = distance;
                        }
                        ans += tmp;
                    }
                }
            }

            if(min > ans) min = ans;

            return;
        }
        for(int i=start; i<size; i++){
            num[cnt] = arr[i];
            combination(cnt+1, i+1);
        }
    }
}
