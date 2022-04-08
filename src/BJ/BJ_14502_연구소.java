package BJ;

import com.sun.xml.internal.ws.encoding.soap.SOAP12Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_14502_연구소 {

    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<int[]> wall;

    static int[] input;
    static int[] num;

    static int max = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        wall = new ArrayList<int[]>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0) wall.add(new int[]{i, j});
            }
        } //입력

        //System.out.println(wall.size());
        input = new int[wall.size()];
        for(int i=0; i< wall.size(); i++){
            input[i] = i;
        }
        num = new int[3];

        build(0, 0);

        System.out.println(max);
    }

    static int[][] copyMap;
    private static void build(int cnt, int start){
        if(cnt == 3){
            // 해당 부분 1로 변경
            for(int i=0; i<3; i++){
                int a = wall.get(num[i])[0];
                int b = wall.get(num[i])[1];

                map[a][b] = 1;
            }

            visited = new boolean[n][m];
            copyMap = new int[n][m];
            copy(map, copyMap);
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(copyMap[i][j] == 2) virus(i, j); //바이러스 퍼뜨리기
                }
            }

            max = Math.max(max, cnt());

            // 해당 부분 0로 변경
            for(int i=0; i<3; i++){
                int a = wall.get(num[i])[0];
                int b = wall.get(num[i])[1];

                map[a][b] = 0;
            }

            return;
        }

        for(int i=start; i<wall.size(); i++){
            num[cnt] = input[i];
            build(cnt+1, i+1);
        }
    }

    private static void virus(int x, int y){
        visited[x][y] = true;
        for(int d=0; d<4; d++){
            int rx = x + dx[d];
            int ry = y + dy[d];

            if(rx < 0 || rx >= n || ry < 0 || ry >= m ||
                    visited[rx][ry] || copyMap[rx][ry] != 0) continue;

            copyMap[rx][ry] = 2;
            virus(rx, ry);
        }
    }

    private static int cnt(){
        int res = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(copyMap[i][j] == 0) res++;
            }
        }
        return res;
    }

    private static void copy(int[][] a, int[][] b){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                b[i][j] = a[i][j];
            }
        }
    }


}
