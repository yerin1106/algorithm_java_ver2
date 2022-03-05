package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1091_카드섞기 {

    static int[][] player;
    static int[] arr;
    static int n;
    static int[] s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        int[] p = new int[n];
        player = new int[3][n/3];
        int[] cnt = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            p[i] = Integer.parseInt(st.nextToken());
            if(cnt[p[i]] < n/3){
                player[p[i]][cnt[p[i]]] = i;
                cnt[p[i]]++;
            }
        }

        s = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            s[i] = Integer.parseInt(st.nextToken());
        }

        arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = i;
        }

        int[] tmp = Arrays.copyOf(arr, arr.length);

        int ans = 0;

        while(true){
            //System.out.println(ans + "::::"+ Arrays.toString(tmp));

            //나눠 줄 수 있는지 체크
            if(give(tmp)) {
                System.out.println(ans);
                break;
            }

            //섞어도 카드를 플레이어에게 줄 수 없는 경우
            if(check(tmp) && ans != 0) {
                System.out.println(-1);
                break;
            }

            //섞기
            int[] empty = new int[n];
            for(int i=0; i<n; i++){
                empty[s[i]] = tmp[i];
            }

            ans++;
            tmp = Arrays.copyOf(empty, empty.length);
        }
    }

    public static boolean visit(int[] tmp, int p){
        int[] visited = new int[n/3];
        int std = 0;
        for(int i=p; i<n; i+=3){
            for(int j=0; j<n/3; j++){
                if(tmp[i] == player[p][j]) visited[std] = 1;
            }
            std++;
        }

        // 모든 visited 원소가 1이 아니면 원하는대로 섞이지 않았다는 말
        for(int i=0; i<visited.length; i++){
            if(visited[i] != 1) return false;
        }
        return true;
    }

    public static boolean give(int[] tmp){
        // player 0
        if(!visit(tmp, 0)) return false;

        // player 1
        if(!visit(tmp, 1)) return false;

        // player 2
        if(!visit(tmp, 2)) return false;

        return true;
    }

    // 처음 ( 0, 1, 2)처럼 순서대로 정렬되어 있을 경우 cycle이 존재한다는 의미
    public static boolean check(int[] tmp){
        for(int i=0; i<n; i++){
            if(tmp[i] != arr[i]) return false;
        }
        return true;
    }
}
