package JO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JO_1681_해밀턴순환회로 {

    static boolean[] vistied;
    static int[] arr;
    //static int[] numbers;
    static int n;

    static int[][] map;
    static int min = Integer.MAX_VALUE;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n-1];
        //numbers = new int[n-1];
        //vistied = new boolean[n-1];
        for(int i=1; i<n; i++){
            arr[i-1] = i;
        }

        map = new int[n][n];

        for(int i=0; i<n; i++){
            String[] line = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        for(int j=1; j<n; j++){
            vistied = new boolean[n];
            sum = 0;
            if(map[0][j] != 0) dfs(0, j, 1);
        }

        //permutation(0);

        System.out.println(min);
    }

    public static void dfs(int x, int y, int cnt){
        if(sum > min) return;

        sum += map[x][y];
        vistied[x] = true;

        if(cnt == (n-1)){
            if(map[y][0] == 0) return;
            sum = sum + map[y][0];

            min = Math.min(min, sum);
            sum = sum - map[y][0];
            return;
        }

        for(int i=0; i<n; i++){
            if(!vistied[i] && map[y][i] != 0 && sum<min){
                dfs(y, i, cnt+1);
                sum = sum - map[y][i];
                vistied[i] = false;
            }
        }
    }

    //시간초과
//    public static void permutation(int cnt){
//        if(cnt == n-1){
//            if(map[0][numbers[0]] == 0) return;
//
//            int result = map[0][numbers[0]];
//            for(int i=1; i<cnt; i++){
//                if(map[numbers[i-1]][numbers[i]] == 0) return;
//                result += map[numbers[i-1]][numbers[i]];
//            }
//            result += map[numbers[cnt-1]][0];
//
//            if(result < min) min = result;
//
//            return;
//        }
//
//        for(int i=0; i<n-1; i++){
//            if(vistied[i]) continue;
//            numbers[cnt] = arr[i];
//            vistied[i] = true;
//            permutation(cnt+1);
//            vistied[i] = false;
//        }
//    }
}
