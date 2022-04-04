package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 최대한 많은 core를 연결, 전선의 길이는 최소
public class SWEA_프로세서연결하기 {

    static int n, map[][];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static ArrayList<Process> list;

    static int min, max;

    static class Process{
        int x;
        int y;

        Process(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int t = Integer.parseInt(br.readLine());

        for(int tc = 1; tc<=t; tc++){
            n = Integer.parseInt(br.readLine());

            map = new int[n][n];
            list = new ArrayList<>();
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] == 1){
                        if(i-1<0 || j-1<0 || i+1 >= n || j+1 >= n) continue;
                        list.add(new Process(i, j)); //벽에 붙어있지 않은 core 저장
                    }
                }
            }

            min = Integer.MAX_VALUE;
            max = 0;

            dfs(0,0,0);

            System.out.println("#" + tc + " " + min);
        }
    }

    public static void dfs(int idx, int coreCnt, int len){ //코어의 index, 코어의 수, 전선의 길이
        if(idx == list.size()){
            if(max < coreCnt){
                max = coreCnt;
                min = len;
            }
            else if(max == coreCnt){
                if(min > len) min = len;
            }
            return;
        }
        int x = list.get(idx).x;
        int y = list.get(idx).y;

        for(int dir = 0; dir<4; dir++){
            int count = 0;
            // 전선 연결할 때 사용
            int originX = x;
            int originY = y;

            // 탐색할 때 사용(4방중 한방향으로)
            int rx = x;
            int ry = y;

            while(true){ //외곽을 만날때까지 (외곽을 만나던가, 코어를 만나던가)
                rx += dx[dir];
                ry += dy[dir];

                if(rx < 0 || ry < 0 || rx >=n || ry >=n) break;

                if(map[rx][ry] == 1){ //core 만남 //연결할 수 없음
                    count = 0;
                    break;
                }
                count++;
            }

            // 전선연결
            for(int i=0; i<count; i++){
                originX += dx[dir];
                originY += dy[dir];

                map[originX][originY] = 1;
            }

            if(count == 0) dfs(idx+1, coreCnt, len); //연결한 전선 없음
            else{//연결한 전선 있음
                dfs(idx+1, coreCnt+1, len+count);

                originX = x;
                originY = y;

                //전선 연결 한 것, 원상복귀
                for(int i=0; i<count; i++){
                    originX += dx[dir];
                    originY += dy[dir];

                    map[originX][originY] = 0;
                }
            }
        }
    }






}
